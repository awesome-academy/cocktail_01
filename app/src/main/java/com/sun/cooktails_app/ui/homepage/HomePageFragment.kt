package com.sun.cooktails_app.ui.homepage

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.sun.cooktails_app.R
import com.sun.cooktails_app.base.BaseFragment
import com.sun.cooktails_app.ui.cocktail.CocktailsPageFragment
import com.sun.cooktails_app.ui.favorite.FavouritePageFragment
import com.sun.cooktails_app.ui.filter.FilterPageFragment
import com.sun.cooktails_app.utils.ItemBottomNav
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePageFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_home_page

    override fun onViewCreated(view: View) {
        onInitViewPager()
        onInitNav()
    }

    private fun onInitViewPager() {
        val listFragment = listOf(
            CocktailsPageFragment.newInstance(),
            FilterPageFragment.newInstance(),
            FavouritePageFragment.newInstance()
        )
        fragmentManager?.let {
            viewPagerHomePage.adapter = HomePageAdapter(it, listFragment)
        }
    }

    private fun onInitNav() {
        bottomNavHomePage.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemCocktailsPage -> {
                    viewPagerHomePage.currentItem = ItemBottomNav.COCKTAILS_ITEM.ordinal
                    true
                }
                R.id.itemFilterPage -> {
                    viewPagerHomePage.currentItem = ItemBottomNav.FILTER_ITEM.ordinal
                    true
                }
                R.id.itemFavoritePage -> {
                    viewPagerHomePage.currentItem = ItemBottomNav.FAVORITE_ITEM.ordinal
                    true
                }
                else -> false
            }
        }
        viewPagerHomePage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavHomePage.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(position: Int) {
            }
        })
    }

    companion object {
        fun newInstance() = HomePageFragment()
    }
}
