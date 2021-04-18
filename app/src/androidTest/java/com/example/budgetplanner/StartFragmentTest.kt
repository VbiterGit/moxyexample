package com.example.budgetplanner

import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.budgetplanner.ui.start.StartFragment
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StartFragmentTest {
//    @Test
//    fun testLaunchStartFragment(){
//        val scenario = launchFragment { StartFragment() }
//        scenario.moveToState(Lifecycle.State.RESUMED)
//        scenario.onFragment { }
//        scenario.recreate()
//    }

    @Test
    fun testNavigateViewPagerFragment(){
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val startFragmentScenario = launchFragmentInContainer { StartFragment() }
        startFragmentScenario.onFragment{
            navController.setGraph(R.navigation.nav_graph)

            Navigation.setViewNavController(it.requireView(), navController)
        }

        onView(ViewMatchers.withId(R.id.btn_view_pager)).perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.viewPagerFragment)
    }
}