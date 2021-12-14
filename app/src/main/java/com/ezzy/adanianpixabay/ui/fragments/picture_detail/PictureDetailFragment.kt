package com.ezzy.adanianpixabay.ui.fragments.picture_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ezzy.adanianpixabay.R
import com.ezzy.adanianpixabay.databinding.FragmentPictureDetailBinding
import com.ezzy.adanianpixabay.domain.model.Image
import com.ezzy.adanianpixabay.util.applyImage
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PictureDetailFragment : Fragment() {

    private var _binding: FragmentPictureDetailBinding? = null
    private val binding get() = _binding!!

    private val args: PictureDetailFragmentArgs by navArgs()
    private var image: Image? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPictureDetailBinding.inflate(inflater, container, false)

        args.image.let { image = it }
        setUpUi()

        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image?.let { img ->
            with(binding) {
                imageMain.applyImage(img.webformatURL)
                userImage.applyImage(img.userImageURL)
                name.text = img.user

                val tags = stringToList(img.tags)
                tags.forEach { tag ->
                    val tagChip = LayoutInflater.from(requireContext())
                        .inflate(R.layout.chip_item, null, false)
                            as Chip
                    tagChip.apply { text = tag }
                    tagsChipGroup.addView(tagChip)
                }

                downloads.text = img.downloads.toString()
                likes.text = img.likes.toString()
                views.text = img.views.toString()
                comments.text = img.comments.toString()
                imageWidth.text = img.imageWidth.toString()
                imageHeight.text = img.imageHeight.toString()
                imageSize.text = img.imageSize.toString()
            }
        }
    }

    private fun stringToList(string: String): List<String> =
        string.trim().splitToSequence(", ")
            .filter { it.isNotEmpty() }
            .toList()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}