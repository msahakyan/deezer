package coders.android.msahakyan.deezer


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coders.android.msahakyan.deezer.R

/**
 * A simple [Fragment] subclass.
 */
class AlbumDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_detail, container, false)
    }


}
