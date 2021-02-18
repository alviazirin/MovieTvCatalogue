package com.dicoding.movietvcatalogue.activity.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.IdlingRegistry
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.utils.EspressoIdlingResource

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    private val movieTitle = "Wonder Woman 1984"
    private val movieYear = "2020"
    private val movieGenre = "Fantasy, Action, Adventure"
    private val movieProd =
        "DC Entertainment, Warner Bros. Pictures, The Stone Quarry, DC Films, Atlas Entertainment, DC Comics"
    private val movieOverview =
        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah."

    private val tvTitle = "WandaVision"
    private val tvYear = "2021"
    private val tvGenre = "Sci-Fi & Fantasy, Mystery, Comedy, Drama"
    private val tvProd = "Marvel Studios"
    private val tvOverview =
        "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems."

    @Before
    fun init() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }


    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun toDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_creator_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_title)).check(matches(withText(movieTitle)))
        onView(withId(R.id.tv_year)).check(matches(withText(movieYear)))
        onView(withId(R.id.tv_genre)).check(matches(withText(movieGenre)))
        onView(withId(R.id.tv_creator_director)).check(matches(withText(movieProd)))
        onView(withId(R.id.tv_description)).check(matches(withText(movieOverview)))
    }

    @Test
    fun toDetailTvShow() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_creator_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_title)).check(matches(withText(tvTitle)))
        onView(withId(R.id.tv_year)).check(matches(withText(tvYear)))
        onView(withId(R.id.tv_genre)).check(matches(withText(tvGenre)))
        onView(withId(R.id.tv_creator_director)).check(matches(withText(tvProd)))
        onView(withId(R.id.tv_description)).check(matches(withText(tvOverview)))
    }

    @Test
    fun detailShowShare() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fab_share)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_share)).perform(click())
    }
}