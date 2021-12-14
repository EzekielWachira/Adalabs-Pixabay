package com.ezzy.adanianpixabay.ui.fragments.pictures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezzy.adanianpixabay.R
import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.data.remote.dto.toImage
import com.ezzy.adanianpixabay.databinding.FragmentPicturesBinding
import com.ezzy.adanianpixabay.domain.model.Image
import com.ezzy.adanianpixabay.util.hideView
import com.ezzy.adanianpixabay.util.makeVisible
import com.ezzy.adanianpixabay.util.showToast
import com.google.android.material.divider.MaterialDividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class PicturesFragment : Fragment() {

    private var _binding: FragmentPicturesBinding? = null
    private val binding get() = _binding!!

    private val picturesViewModel: PictureViewModel by viewModels()
    private val imageAdapter: ImageAdapter by lazy { ImageAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPicturesBinding.inflate(inflater, container, false)

        setUpUi()

        picturesViewModel.searchImages("dog")

        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            btnSearch.setOnClickListener {
                picturesViewModel.searchImages(etSearch.text.toString())
            }

            etSearch.addTextChangedListener {
                if (it.toString().isEmpty()) {
                    picturesViewModel.getImages()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.picturesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = imageAdapter
            val divider =
                MaterialDividerItemDecoration(context, LinearLayoutManager.VERTICAL).apply {
                    dividerColor = ContextCompat.getColor(requireContext(), R.color.grey_20)
                }
            addItemDecoration(divider)
        }

        imageAdapter.setOnClickListener {
            var bundle = bundleOf("image" to it)
            findNavController().navigate(
                R.id.action_picturesFragment_to_pictureDetailFragment,
                bundle
            )
        }

        initUiState()
    }

    private fun initUiState() {
        lifecycleScope.launchWhenCreated {
            picturesViewModel.imagesState.collect { state ->
                with(binding) {
                    when (state) {
                        is Resource.Loading -> {
                            layoutNoData.hideView()
                            spinKit.makeVisible()
                        }

                        is Resource.Success -> {
                            layoutNoData.hideView()
                            spinKit.hideView()
                            imageAdapter.submitList(state.data.hits.map { it.toImage() })
                        }

                        is Resource.Failure -> {
                            spinKit.hideView()
                            layoutNoData.makeVisible()
                            showToast(state.errorMessage!!)
                        }

                        is Resource.Empty -> {
                            spinKit.hideView()
                            layoutNoData.makeVisible()
                        }
                    }
                }
            }
        }
    }

//    override fun onClick(image: Image) {

//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}