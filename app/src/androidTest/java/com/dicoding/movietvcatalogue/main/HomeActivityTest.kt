package com.dicoding.movietvcatalogue.main


import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.main.movie.MoviesFragment
import com.dicoding.movietvcatalogue.main.movie.MoviesViewModel
import com.dicoding.movietvcatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyDetailMovie()
    private val dummyTvShow = DataDummy.generateDummyDetailTVShow()
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var activity: HomeActivity
    private lateinit var moviesFragment: MoviesFragment



    @Before
    fun init (){
      ActivityScenario.launch(HomeActivity::class.java)
    }



    @Test
    fun loadMovie(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadTvShow(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun toDetailMovies(){
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                click()
            ))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_creator_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_year)).check(matches(withText(dummyMovie[0].year)))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_creator_director)).check(matches(withText(dummyMovie[0].producer)))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun toDetailTvShow(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                click()
            ))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_creator_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_year)).check(matches(withText(dummyTvShow[0].year)))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tv_creator_director)).check(matches(withText(dummyTvShow[0].producer)))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyTvShow[0].overview)))
    }

    @Test
    fun detailShowShare(){
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                click()
            ))
        onView(withId(R.id.fab_share)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_share)).perform(click())
    }
}