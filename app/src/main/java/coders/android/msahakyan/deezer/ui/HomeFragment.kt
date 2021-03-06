package coders.android.msahakyan.deezer.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coders.android.msahakyan.deezer.R
import coders.android.msahakyan.deezer.ui.common.LanesAdapter
import coders.android.msahakyan.deezer.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.recycler_view
import kotlinx.android.synthetic.main.fragment_home.toolbar
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author msahakyan.
 */

class HomeFragment : Fragment() {

    @ExperimentalCoroutinesApi
    private val viewModel: HomeViewModel by viewModel()

    private lateinit var lanesAdapter: LanesAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLanesAdapter()
    }

    private fun setupLanesAdapter() {
        lanesAdapter = LanesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWidgets()
        registerObservers()
    }

    private fun setupWidgets() {
        toolbar.title = getString(R.string.app_name)
        layoutManager = LinearLayoutManager(context)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = lanesAdapter
    }

    @ExperimentalCoroutinesApi
    private fun registerObservers() {
        viewModel.lanesLiveData.observe(viewLifecycleOwner, Observer {
            with(lanesAdapter) {
                setContent(it)
            }
        })
    }
}

fun <T> MutableCollection<T>.replaceAll(items: Collection<T>) =
    apply {
        clear()
        addAll(items)
    }
