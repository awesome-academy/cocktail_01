package com.sun.cooktails_app.ui.cocktail

import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.sun.cooktails_app.R
import com.sun.cooktails_app.base.BaseFragment
import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.data.source.remote.CocktailRemoteDataSource
import com.sun.cooktails_app.data.source.repository.CocktailsRepository
import kotlinx.android.synthetic.main.fragment_popular.*
import java.lang.Exception

class CocktailsPageFragment : BaseFragment(), CocktailsContact.View {

    private lateinit var cocktailsPresenter: CocktailsPresenter
    private val adapterCocktails by lazy {
        CocktailsAdapter() {
        }
    }
    private val gridLayoutManager = GridLayoutManager(context, 2)


    override fun getLayoutId() = R.layout.fragment_popular

    override fun onViewCreated(view: View) {
        initView()
        initData()
    }

    override fun onGetCocktailsSuccess(cocktails: MutableList<Popular?>) {
        adapterCocktails.setData(cocktails)
    }

    override fun onError(exception: Exception?) {}

    private fun initView() {
        initRecyclerView()
    }

    private fun initData() {
        cocktailsPresenter = CocktailsPresenter(
            CocktailsRepository.getInstance(
                CocktailRemoteDataSource.getInstance()
            )
        )
        cocktailsPresenter.setView(this)
        cocktailsPresenter.onStart()
    }

    private fun initRecyclerView() {
        recyclerViewCocktails.apply {
            setHasFixedSize(true)
            adapter = adapterCocktails
            layoutManager = gridLayoutManager
        }
    }

    private fun setButtonClick(button: Button) {
        button.apply {
            background = ResourcesCompat.getDrawable(
                resources, R.drawable.custom_cocktails_screen_button, null
            )
            setTextColor(ContextCompat.getColor(context, R.color.black))
        }
    }

    private fun setButtonNotClick(button: Button) {
        button.apply {
            background = ResourcesCompat.getDrawable(
                resources, R.drawable.custom_cocktails_screen_button_not_click, null
            )
            setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }

    companion object {
        fun newInstance() = CocktailsPageFragment()
    }
}
