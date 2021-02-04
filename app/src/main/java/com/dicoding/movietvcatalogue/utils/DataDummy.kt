package com.dicoding.movietvcatalogue.utils

import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieTvDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieTvResponse
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity

object DataDummy {

    private lateinit var  dataAll : List<MovieTvDetailEntity>
    private lateinit var detailData: MovieTvDetailEntity

    private val moviePoster = intArrayOf(
        R.drawable.poster_infinity_war,
        R.drawable.poster_a_start_is_born,
        R.drawable.poster_alita,
        R.drawable.poster_aquaman,
        R.drawable.poster_bohemian,
        R.drawable.poster_cold_persuit,
        R.drawable.poster_creed,
        R.drawable.poster_crimes,
        R.drawable.poster_glass,
        R.drawable.poster_how_to_train,
        R.drawable.poster_marry_queen,
        R.drawable.poster_master_z,
        R.drawable.poster_mortal_engines,
        R.drawable.poster_overlord,
        R.drawable.poster_ralph,
        R.drawable.poster_robin_hood,
        R.drawable.poster_serenity,
        R.drawable.poster_spiderman,
        R.drawable.poster_t34
    )


    private val tvShowPoster = intArrayOf(
            R.drawable.poster_arrow,
            R.drawable.poster_doom_patrol,
            R.drawable.poster_dragon_ball,
            R.drawable.poster_fairytail,
            R.drawable.poster_flash,
            R.drawable.poster_god,
            R.drawable.poster_gotham,
            R.drawable.poster_grey_anatomy,
            R.drawable.poster_hanna,
            R.drawable.poster_iron_fist,
            R.drawable.poster_naruto_shipudden,
            R.drawable.poster_the_walking_dead
    )

    fun generateDummyMovie(): ArrayList<MovieTVEntity>{
        val movies = ArrayList<MovieTVEntity>()

        movies.add(MovieTVEntity(1,"Avengers: Endgame","2019","https://image.tmdb.org/t/p/original/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"))
        movies.add(MovieTVEntity(2,"A Star is Born","2018","https://image.tmdb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))
        movies.add(MovieTVEntity(3,"Alita: Battle Angel","2019","https://image.tmdb.org/t/p/original/xRWht48C2V8XNfzvPehyClOvDni.jpg"))
        movies.add(MovieTVEntity(4,"Aquaman","2018","https://image.tmdb.org/t/p/original/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"))
        movies.add(MovieTVEntity(5,"Bohemian Rhapsody","2018","https://image.tmdb.org/t/p/original/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))
        movies.add(MovieTVEntity(6,"Cold Pursuit","2019","https://image.tmdb.org/t/p/original/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"))
        movies.add(MovieTVEntity(7,"Creed II","2018","https://image.tmdb.org/t/p/original/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))
        movies.add(MovieTVEntity(8,"Fantastic Beasts: The Crimes of Grindelwald","2018","https://image.tmdb.org/t/p/original/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))
        movies.add(MovieTVEntity(9,"Glass","2019","https://image.tmdb.org/t/p/original/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))
        movies.add(MovieTVEntity(10,"How to Train Your Dragon: The Hidden World","2019","https://image.tmdb.org/t/p/original/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))
        movies.add(MovieTVEntity(11,"Mary Queen of Scots","2018","https://image.tmdb.org/t/p/original/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg"))
        movies.add(MovieTVEntity(12,"Master Z: Ip Man Legacy","2018","https://image.tmdb.org/t/p/original/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg"))
        movies.add(MovieTVEntity(13,"Mortal Engines","2018","https://image.tmdb.org/t/p/original/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"))
        movies.add(MovieTVEntity(14,"Overlord","2018","https://image.tmdb.org/t/p/original/l76Rgp32z2UxjULApxGXAPpYdAP.jpg"))
        movies.add(MovieTVEntity(15,"Wreck-It Ralph","2012","https://image.tmdb.org/t/p/original/nsUAgWCxqbTD9wkKrv3nBGH2DVk.jpg"))
        movies.add(MovieTVEntity(16,"Robin Hood","2018","https://image.tmdb.org/t/p/original/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"))
        movies.add(MovieTVEntity(17,"Serenity","2019","https://image.tmdb.org/t/p/original/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg"))
        movies.add(MovieTVEntity(18,"Spider-Man: Into the Spider-Verse","2018","https://image.tmdb.org/t/p/original/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"))
        movies.add(MovieTVEntity(19,"T-34","2018","https://image.tmdb.org/t/p/original/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg"))

        return movies
    }

    fun generateDummyTvShow(): ArrayList<MovieTVEntity>{
        val tvShow = ArrayList<MovieTVEntity>()

        tvShow.add(MovieTVEntity(20,"Arrow","2012","https://image.tmdb.org/t/p/original/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))
        tvShow.add(MovieTVEntity(21,"Doom Patrol","2019","https://image.tmdb.org/t/p/original/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))
        tvShow.add(MovieTVEntity(22,"Dragon Ball","1996","https://image.tmdb.org/t/p/original/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))
        tvShow.add(MovieTVEntity(23,"Fairy Tail","2009","https://image.tmdb.org/t/p/original/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg"))
        tvShow.add(MovieTVEntity(24,"The Flash","2014","https://image.tmdb.org/t/p/original/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"))
        tvShow.add(MovieTVEntity(25,"Game of Thrones","2011","https://image.tmdb.org/t/p/original/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"))
        tvShow.add(MovieTVEntity(26,"Gotham","2014","https://image.tmdb.org/t/p/original/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))
        tvShow.add(MovieTVEntity(27,"Grey's Anatomy","2005","https://image.tmdb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))
        tvShow.add(MovieTVEntity(28,"Hanna","2019","https://image.tmdb.org/t/p/original/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"))
        tvShow.add(MovieTVEntity(29,"Marvel's Iron Fist","2017","https://image.tmdb.org/t/p/original/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg"))
        tvShow.add(MovieTVEntity(30,"Naruto Shippūden","2007","https://image.tmdb.org/t/p/original/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg"))
        tvShow.add(MovieTVEntity(31,"The Walking Dead","2010","https://image.tmdb.org/t/p/original/qgjP2OrrX9gc6M270xdPnEmE9tC.jpg"))

        return tvShow
    }

    fun generateDetail(id: String): MovieTvDetailEntity{
        lateinit var showDetail: MovieTvDetailEntity
        val shows = ArrayList<MovieTvDetailEntity>()

        shows.add(MovieTvDetailEntity(1,
            "Avengers: Endgame",
            "2019",
            "Adventure, Science Fiction, Action",
            "Anthony Russo",
            "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
            "https://www.themoviedb.org/movie/299536-avengers-infinity-war",
            "https://image.tmdb.org/t/p/original/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"))
        shows.add(MovieTvDetailEntity(2,
            "A Star is Born",
            "2018",
            "Drama, Romance, Music",
            "Bradley Cooper",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "https://www.themoviedb.org/movie/332562-a-star-is-born",
            "https://image.tmdb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))
        shows.add(
            MovieTvDetailEntity(3,
                "Alita: Battle Angel",
                "2019",
                "Action, Science Fiction, Adventure",
                "Robert Rodriguez",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "https://www.themoviedb.org/movie/399579-alita-battle-angel",
                "https://image.tmdb.org/t/p/original/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )
        shows.add(
            MovieTvDetailEntity(4,
                "Aquaman",
                "2018",
                "Action, Adventure, Fantasy",
                "James Wan",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/movie/297802-aquaman",
                "https://image.tmdb.org/t/p/original/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
        )
        shows.add(
            MovieTvDetailEntity(5,
                "Bohemian Rhapsody",
                "2018",
                "Music, Drama",
                "Anthony McCarten",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/movie/424694-bohemian-rhapsody",
                "https://image.tmdb.org/t/p/original/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )
        shows.add(
            MovieTvDetailEntity(6,
                "Cold Pursuit",
                "2019",
                "Action, Crime, Thriller",
                "Hans Petter Moland",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/movie/438650-cold-pursuit",
                "https://image.tmdb.org/t/p/original/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
        )
        shows.add(
            MovieTvDetailEntity(7,
                "Creed II",
                "2018",
                "Drama",
                "Sylvester Stallone",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://www.themoviedb.org/movie/480530-creed-ii",
                "https://image.tmdb.org/t/p/original/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )
        shows.add(
            MovieTvDetailEntity(8,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018",
                "Adventure, Fantasy, Drama",
                "David Yates",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "https://www.themoviedb.org/movie/338952-fantastic-beasts-the-crimes-of-grindelwald",
                "https://image.tmdb.org/t/p/original/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))
        shows.add(
            MovieTvDetailEntity(9,
                "Glass",
                "2019",
                "Thriller, Drama, Science Fiction",
                "M. Night Shyamalan",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://www.themoviedb.org/movie/450465-glass",
                "https://image.tmdb.org/t/p/original/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )
        shows.add(
            MovieTvDetailEntity(10,
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "Animation, Family, Adventure",
                "Dean DeBlois",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://www.themoviedb.org/movie/166428-how-to-train-your-dragon-3",
                "https://image.tmdb.org/t/p/original/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg")
        )
        shows.add(
            MovieTvDetailEntity(11,
                "Mary Queen of Scots",
                "2018",
                "Drama, History",
                "Josie Rourke",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "https://www.themoviedb.org/movie/457136-mary-queen-of-scots",
                "https://image.tmdb.org/t/p/original/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg")
        )
        shows.add(
            MovieTvDetailEntity(12,
                "Master Z: Ip Man Legacy",
                "2018",
                "Action",
                "Yuen Woo-ping",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "https://www.themoviedb.org/movie/450001-cheung-tin-chi",
                "https://image.tmdb.org/t/p/original/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg")
        )
        shows.add(
            MovieTvDetailEntity(13,
                "Mortal Engines",
                "2018",
                "Adventure, Fantasy",
                "Christian Rivers",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "https://www.themoviedb.org/movie/428078-mortal-engines",
                "https://image.tmdb.org/t/p/original/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg")
        )
        shows.add(
            MovieTvDetailEntity(14,
                "Overlord",
                "2018",
                "Horror, War, Science Fiction",
                "Billy Ray",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "https://www.themoviedb.org/movie/438799-overlord",
                "https://image.tmdb.org/t/p/original/l76Rgp32z2UxjULApxGXAPpYdAP.jpg")
        )
        shows.add(
            MovieTvDetailEntity(15,
                "Wreck-It Ralph",
                "2012",
                "Family, Animation, Comedy, Adventure",
                "Rich Moore",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                "https://www.themoviedb.org/movie/82690-wreck-it-ralph",
                "https://image.tmdb.org/t/p/original/nsUAgWCxqbTD9wkKrv3nBGH2DVk.jpg")
        )
        shows.add(
            MovieTvDetailEntity(16,
                "Robin Hood",
                "2018",
                "Adventure, Action, Thriller",
                "Ben Chandler",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "https://www.themoviedb.org/movie/375588-robin-hood-origins",
                "https://image.tmdb.org/t/p/original/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg")
        )
        shows.add(MovieTvDetailEntity(17,
            "Serenity",
            "2019",
            "Thriller, Mystery, Drama",
            "Steven Knight",
            "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help",
            "https://www.themoviedb.org/movie/452832-serenity",
            "https://image.tmdb.org/t/p/original/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg"))
        shows.add(
            MovieTvDetailEntity(18,
                "Spider-Man: Into the Spider-Verse",
                "2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "Rodney Rothman",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "https://www.themoviedb.org/movie/324857-spider-man-into-the-spider-verse",
                "https://image.tmdb.org/t/p/original/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg")
        )
        shows.add(
            MovieTvDetailEntity(19,
                "T-34",
                "2018",
                "War, Action, Drama, History",
                "Alexey Sidorov",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "https://www.themoviedb.org/movie/505954-34",
                "https://image.tmdb.org/t/p/original/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg")
        )
        shows.add(MovieTvDetailEntity(20,
            "Arrow",
            "2012",
            "Crime, Drama, Mystery, Action & Adventure",
            "Greg Berlanti",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "https://www.themoviedb.org/tv/1412-arrow",
            "https://image.tmdb.org/t/p/original/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))
        shows.add(MovieTvDetailEntity(21,
            "Doom Patrol",
            "2019",
            "Sci-Fi & Fantasy, Action & Adventure, Comedy",
            "Jeremy Carver",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://www.themoviedb.org/tv/79501-doom-patrol",
            "https://image.tmdb.org/t/p/original/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))
        shows.add(MovieTvDetailEntity(22,
            "Dragon Ball",
            "1996",
            "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
            "Akira Toriyama",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "https://www.themoviedb.org/tv/12609-dragon-ball",
            "https://image.tmdb.org/t/p/original/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))
        shows.add(MovieTvDetailEntity(23,
            "Fairy Tail",
            "2009",
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
            "Hiro Mashima",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "https://www.themoviedb.org/tv/46261-fairy-tail",
            "https://image.tmdb.org/t/p/original/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg"))
        shows.add(MovieTvDetailEntity(24,
            "The Flash",
            "2014",
            "Drama, Sci-Fi & Fantasy",
            "Greg Berlanti",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://www.themoviedb.org/tv/60735-the-flash",
            "https://image.tmdb.org/t/p/original/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"))
        shows.add(MovieTvDetailEntity(25,
            "Game of Thrones",
            "2011",
            "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
            "David Benioff",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://www.themoviedb.org/tv/1399-game-of-thrones",
            "https://image.tmdb.org/t/p/original/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"))
        shows.add(MovieTvDetailEntity(26,
            "Gotham",
            "2014",
            "Drama, Fantasy, Crime",
            "Bruno Heller",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "https://www.themoviedb.org/tv/60708-gotham",
            "https://image.tmdb.org/t/p/original/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))
        shows.add(MovieTvDetailEntity(27,
            "Grey's Anatomy",
            "2005",
            "Drama",
            "Shonda Rhimes",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/tv/1416-grey-s-anatomy",
            "https://image.tmdb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))
        shows.add(MovieTvDetailEntity(28,
            "Hanna",
            "2019",
            "Action & Adventure, Drama",
            "David Farr",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "https://www.themoviedb.org/tv/54155-hanna",
            "https://image.tmdb.org/t/p/original/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"))
        shows.add(MovieTvDetailEntity(29,
            "Marvel's Iron Fist",
            "2017",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "Scott Buck",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "https://www.themoviedb.org/tv/62127-marvel-s-iron-fist",
            "https://image.tmdb.org/t/p/original/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg"))
        shows.add(MovieTvDetailEntity(30,
            "Naruto Shippūden",
            "2007",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "Masashi Kishimoto",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki",
            "https://www.themoviedb.org/tv/31910-naruto-shipp-den",
            "https://image.tmdb.org/t/p/original/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg"))
        shows.add(MovieTvDetailEntity(31,
            "The Walking Dead",
            "2010",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "Frank Darabont",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "https://www.themoviedb.org/tv/1402-the-walking-dead",
            "https://image.tmdb.org/t/p/original/qgjP2OrrX9gc6M270xdPnEmE9tC.jpg"))

        for (show in shows){
            if (show.id.toString() == id){
                showDetail = MovieTvDetailEntity(show.id,
                show.title,
                show.year,
                show.genre,
                show.producer,
                show.overview,
                show.url,
                show.poster)
            }
        }
        return showDetail
    }

    fun generateRemoteSourceMovie(): ArrayList<MovieTvResponse>{
        val movies = ArrayList<MovieTvResponse>()

        movies.add(MovieTvResponse(1,"Avengers: Endgame","2019","https://image.tmdb.org/t/p/original/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"))
        movies.add(MovieTvResponse(2,"A Star is Born","2018","https://image.tmdb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))
        movies.add(MovieTvResponse(3,"Alita: Battle Angel","2019","https://image.tmdb.org/t/p/original/xRWht48C2V8XNfzvPehyClOvDni.jpg"))
        movies.add(MovieTvResponse(4,"Aquaman","2018","https://image.tmdb.org/t/p/original/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"))
        movies.add(MovieTvResponse(5,"Bohemian Rhapsody","2018","https://image.tmdb.org/t/p/original/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))
        movies.add(MovieTvResponse(6,"Cold Pursuit","2019","https://image.tmdb.org/t/p/original/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"))
        movies.add(MovieTvResponse(7,"Creed II","2018","https://image.tmdb.org/t/p/original/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))

        return movies
    }

    fun generateRemoteSourceTvShow(): ArrayList<MovieTvResponse>{
        val shows = ArrayList<MovieTvResponse>()

        shows.add(MovieTvResponse(20,"Arrow","2012","https://image.tmdb.org/t/p/original/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))
        shows.add(MovieTvResponse(21,"Doom Patrol","2019","https://image.tmdb.org/t/p/original/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))
        shows.add(MovieTvResponse(22,"Dragon Ball","1996","https://image.tmdb.org/t/p/original/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))
        shows.add(MovieTvResponse(23,"Fairy Tail","2009","https://image.tmdb.org/t/p/original/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg"))
        shows.add(MovieTvResponse(24,"The Flash","2014","https://image.tmdb.org/t/p/original/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"))
        shows.add(MovieTvResponse(25,"Game of Thrones","2011","https://image.tmdb.org/t/p/original/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"))
        shows.add(MovieTvResponse(26,"Gotham","2014","https://image.tmdb.org/t/p/original/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))

        return shows
    }

    fun generateRemoteSourceDetail(id: String): MovieTvDetailResponse{
        lateinit var showDetail: MovieTvDetailResponse
        val shows = ArrayList<MovieTvDetailResponse>()

        shows.add(MovieTvDetailResponse(1,
            "Avengers: Endgame",
            "2019",
            "Adventure, Science Fiction, Action",
            "Anthony Russo",
            "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
            "https://www.themoviedb.org/movie/299536-avengers-infinity-war",
            "https://image.tmdb.org/t/p/original/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"))
        shows.add(MovieTvDetailResponse(2,
            "A Star is Born",
            "2018",
            "Drama, Romance, Music",
            "Bradley Cooper",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "https://www.themoviedb.org/movie/332562-a-star-is-born",
            "https://image.tmdb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))
        shows.add(
            MovieTvDetailResponse(3,
                "Alita: Battle Angel",
                "2019",
                "Action, Science Fiction, Adventure",
                "Robert Rodriguez",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "https://www.themoviedb.org/movie/399579-alita-battle-angel",
                "https://image.tmdb.org/t/p/original/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )
        shows.add(
            MovieTvDetailResponse(4,
                "Aquaman",
                "2018",
                "Action, Adventure, Fantasy",
                "James Wan",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/movie/297802-aquaman",
                "https://image.tmdb.org/t/p/original/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
        )
        shows.add(
            MovieTvDetailResponse(5,
                "Bohemian Rhapsody",
                "2018",
                "Music, Drama",
                "Anthony McCarten",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/movie/424694-bohemian-rhapsody",
                "https://image.tmdb.org/t/p/original/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )
        shows.add(
            MovieTvDetailResponse(6,
                "Cold Pursuit",
                "2019",
                "Action, Crime, Thriller",
                "Hans Petter Moland",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/movie/438650-cold-pursuit",
                "https://image.tmdb.org/t/p/original/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
        )
        shows.add(
            MovieTvDetailResponse(7,
                "Creed II",
                "2018",
                "Drama",
                "Sylvester Stallone",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "https://www.themoviedb.org/movie/480530-creed-ii",
                "https://image.tmdb.org/t/p/original/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )
        shows.add(MovieTvDetailResponse(20,
            "Arrow",
            "2012",
            "Crime, Drama, Mystery, Action & Adventure",
            "Greg Berlanti",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "https://www.themoviedb.org/tv/1412-arrow",
            "https://image.tmdb.org/t/p/original/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))
        shows.add(MovieTvDetailResponse(21,
            "Doom Patrol",
            "2019",
            "Sci-Fi & Fantasy, Action & Adventure, Comedy",
            "Jeremy Carver",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://www.themoviedb.org/tv/79501-doom-patrol",
            "https://image.tmdb.org/t/p/original/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))
        shows.add(MovieTvDetailResponse(22,
            "Dragon Ball",
            "1996",
            "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
            "Akira Toriyama",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "https://www.themoviedb.org/tv/12609-dragon-ball",
            "https://image.tmdb.org/t/p/original/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))
        shows.add(MovieTvDetailResponse(23,
            "Fairy Tail",
            "2009",
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
            "Hiro Mashima",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "https://www.themoviedb.org/tv/46261-fairy-tail",
            "https://image.tmdb.org/t/p/original/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg"))
        shows.add(MovieTvDetailResponse(24,
            "The Flash",
            "2014",
            "Drama, Sci-Fi & Fantasy",
            "Greg Berlanti",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://www.themoviedb.org/tv/60735-the-flash",
            "https://image.tmdb.org/t/p/original/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"))
        shows.add(MovieTvDetailResponse(25,
            "Game of Thrones",
            "2011",
            "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
            "David Benioff",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://www.themoviedb.org/tv/1399-game-of-thrones",
            "https://image.tmdb.org/t/p/original/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"))
        shows.add(MovieTvDetailResponse(26,
            "Gotham",
            "2014",
            "Drama, Fantasy, Crime",
            "Bruno Heller",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "https://www.themoviedb.org/tv/60708-gotham",
            "https://image.tmdb.org/t/p/original/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))

        for (show in shows){
            if (show.id.toString() == id){
                showDetail = MovieTvDetailResponse(show.id,
                    show.title,
                    show.date,
                    show.genre,
                    show.productionCompanies,
                    show.overview,
                    show.homepage,
                    show.poster)
            }
        }
        return showDetail
    }


    fun generateDummyDetailMovie(movieId: String): MovieTvDetailEntity {
        lateinit var movieDetail: MovieTvDetailEntity
        val movies = ArrayList<MovieTvDetailEntity>()

        movies.add(MovieTvDetailEntity(1,
            "Avengers: Endgame",
            "2019",
            "Adventure, Science Fiction, Action",
        "Anthony Russo",
        "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
            "https://www.themoviedb.org/movie/299536-avengers-infinity-war",
        "https://image.tmdb.org/t/p/original/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"))
        movies.add(MovieTvDetailEntity(2,
            "A Star is Born",
        "2018",
        "Drama, Romance, Music",
        "Bradley Cooper",
        "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "https://www.themoviedb.org/movie/332562-a-star-is-born",
            "https://image.tmdb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"))
        movies.add(
            MovieTvDetailEntity(3,
        "Alita: Battle Angel",
            "2019",
            "Action, Science Fiction, Adventure",
            "Robert Rodriguez",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                    "https://www.themoviedb.org/movie/399579-alita-battle-angel",
                "https://image.tmdb.org/t/p/original/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )
        movies.add(
            MovieTvDetailEntity(4,
        "Aquaman",
            "2018",
            "Action, Adventure, Fantasy",
            "James Wan",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                    "https://www.themoviedb.org/movie/297802-aquaman",
                "https://image.tmdb.org/t/p/original/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg")
        )
        movies.add(
            MovieTvDetailEntity(5,
            "Bohemian Rhapsody",
            "2018",
            "Music, Drama",
            "Anthony McCarten",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/movie/424694-bohemian-rhapsody",
               "https://image.tmdb.org/t/p/original/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )
        movies.add(
            MovieTvDetailEntity(6,
        "Cold Pursuit",
            "2019",
            "Action, Crime, Thriller",
            "Hans Petter Moland",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
             "https://www.themoviedb.org/movie/438650-cold-pursuit",
                "https://image.tmdb.org/t/p/original/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
        )
        movies.add(
            MovieTvDetailEntity(7,
        "Creed II",
            "2018",
            "Drama",
            "Sylvester Stallone",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
             "https://www.themoviedb.org/movie/480530-creed-ii",
                "https://image.tmdb.org/t/p/original/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg")
        )
        movies.add(
            MovieTvDetailEntity(8,
        "Fantastic Beasts: The Crimes of Grindelwald",
            "2018",
            "Adventure, Fantasy, Drama",
            "David Yates",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
             "https://www.themoviedb.org/movie/338952-fantastic-beasts-the-crimes-of-grindelwald",
                "https://image.tmdb.org/t/p/original/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))
        movies.add(
            MovieTvDetailEntity(9,
        "Glass",
            "2019",
            "Thriller, Drama, Science Fiction",
            "M. Night Shyamalan",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
             "https://www.themoviedb.org/movie/450465-glass",
               "https://image.tmdb.org/t/p/original/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )
        movies.add(
            MovieTvDetailEntity(10,
        "How to Train Your Dragon: The Hidden World",
            "2019",
             "Animation, Family, Adventure",
            "Dean DeBlois",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
              "https://www.themoviedb.org/movie/166428-how-to-train-your-dragon-3",
               "https://image.tmdb.org/t/p/original/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg")
        )
        movies.add(
            MovieTvDetailEntity(11,
        "Mary Queen of Scots",
            "2018",
            "Drama, History",
            "Josie Rourke",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
             "https://www.themoviedb.org/movie/457136-mary-queen-of-scots",
               "https://image.tmdb.org/t/p/original/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg")
        )
        movies.add(
            MovieTvDetailEntity(12,
        "Master Z: Ip Man Legacy",
            "2018",
            "Action",
            "Yuen Woo-ping",
            "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
            "https://www.themoviedb.org/movie/450001-cheung-tin-chi",
                "https://image.tmdb.org/t/p/original/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg")
        )
        movies.add(
            MovieTvDetailEntity(13,
        "Mortal Engines",
            "2018",
            "Adventure, Fantasy",
            "Christian Rivers",
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
             "https://www.themoviedb.org/movie/428078-mortal-engines",
                "https://image.tmdb.org/t/p/original/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg")
        )
        movies.add(
            MovieTvDetailEntity(14,
        "Overlord",
            "2018",
            "Horror, War, Science Fiction",
            "Billy Ray",
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
             "https://www.themoviedb.org/movie/438799-overlord",
                "https://image.tmdb.org/t/p/original/l76Rgp32z2UxjULApxGXAPpYdAP.jpg")
        )
        movies.add(
            MovieTvDetailEntity(15,
        "Wreck-It Ralph",
            "2012",
            "Family, Animation, Comedy, Adventure",
            "Rich Moore",
            "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
             "https://www.themoviedb.org/movie/82690-wreck-it-ralph",
                "https://image.tmdb.org/t/p/original/nsUAgWCxqbTD9wkKrv3nBGH2DVk.jpg")
        )
        movies.add(
            MovieTvDetailEntity(16,
        "Robin Hood",
            "2018",
            "Adventure, Action, Thriller",
            "Ben Chandler",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
             "https://www.themoviedb.org/movie/375588-robin-hood-origins",
                "https://image.tmdb.org/t/p/original/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg")
        )
        movies.add(MovieTvDetailEntity(17,
        "Serenity",
        "2019",
        "Thriller, Mystery, Drama",
        "Steven Knight",
        "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help",
         "https://www.themoviedb.org/movie/452832-serenity",
                 "https://image.tmdb.org/t/p/original/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg"))
        movies.add(
            MovieTvDetailEntity(18,
        "Spider-Man: Into the Spider-Verse",
            "2018",
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "Rodney Rothman",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
              "https://www.themoviedb.org/movie/324857-spider-man-into-the-spider-verse",
                "https://image.tmdb.org/t/p/original/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg")
        )
        movies.add(
            MovieTvDetailEntity(19,
        "T-34",
            "2018",
            "War, Action, Drama, History",
            "Alexey Sidorov",
            "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
             "https://www.themoviedb.org/movie/505954-34",
               "https://image.tmdb.org/t/p/original/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg")
        )
        for (movie in movies){
            if (movie.id.toString() == movieId){
                movieDetail.id = movie.id
                movieDetail.title = movie.title
                movieDetail.year = movie.year
                movieDetail.genre = movie.genre
                movieDetail.overview = movie.overview
                movieDetail.url = movie.url
                movieDetail.poster = movie.poster
            }
        }
        return movieDetail
    }

    fun generateDummyDetailTVShow(tvShowId: String): MovieTvDetailEntity {
        lateinit var showDetail: MovieTvDetailEntity
        val shows = ArrayList<MovieTvDetailEntity>()

        shows.add(MovieTvDetailEntity(1,
        "Arrow",
        "2012",
        "Crime, Drama, Mystery, Action & Adventure",
        "Greg Berlanti",
        "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
        "https://www.themoviedb.org/tv/1412-arrow",
            "https://image.tmdb.org/t/p/original/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))
        shows.add(MovieTvDetailEntity(2,
        "Doom Patrol",
        "2019",
        "Sci-Fi & Fantasy, Action & Adventure, Comedy",
        "Jeremy Carver",
        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
        "https://www.themoviedb.org/tv/79501-doom-patrol",
            "https://image.tmdb.org/t/p/original/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))
        shows.add(MovieTvDetailEntity(3,
        "Dragon Ball",
        "1996",
        "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
        "Akira Toriyama",
        "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
          "https://www.themoviedb.org/tv/12609-dragon-ball",
            "https://image.tmdb.org/t/p/original/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))
        shows.add(MovieTvDetailEntity(4,
        "Fairy Tail",
        "2009",
        "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
        "Hiro Mashima",
        "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
         "https://www.themoviedb.org/tv/46261-fairy-tail",
            "https://image.tmdb.org/t/p/original/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg"))
        shows.add(MovieTvDetailEntity(5,
        "The Flash",
        "2014",
        "Drama, Sci-Fi & Fantasy",
        "Greg Berlanti",
        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
         "https://www.themoviedb.org/tv/60735-the-flash",
            "https://image.tmdb.org/t/p/original/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"))
        shows.add(MovieTvDetailEntity(6,
        "Game of Thrones",
        "2011",
        "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
        "David Benioff",
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
         "https://www.themoviedb.org/tv/1399-game-of-thrones",
           "https://image.tmdb.org/t/p/original/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"))
        shows.add(MovieTvDetailEntity(7,
        "Gotham",
        "2014",
        "Drama, Fantasy, Crime",
        "Bruno Heller",
        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
        "https://www.themoviedb.org/tv/60708-gotham",
            "https://image.tmdb.org/t/p/original/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))
        shows.add(MovieTvDetailEntity(8,
        "Grey's Anatomy",
        "2005",
        "Drama",
        "Shonda Rhimes",
        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
         "https://www.themoviedb.org/tv/1416-grey-s-anatomy",
            "https://image.tmdb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))
        shows.add(MovieTvDetailEntity(9,
        "Hanna",
        "2019",
        "Action & Adventure, Drama",
        "David Farr",
        "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
         "https://www.themoviedb.org/tv/54155-hanna",
         "https://image.tmdb.org/t/p/original/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"))
        shows.add(MovieTvDetailEntity(10,
        "Marvel's Iron Fist",
        "2017",
        "Action & Adventure, Drama, Sci-Fi & Fantasy",
        "Scott Buck",
        "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
         "https://www.themoviedb.org/tv/62127-marvel-s-iron-fist",
            "https://image.tmdb.org/t/p/original/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg"))
        shows.add(MovieTvDetailEntity(11,
        "Naruto Shippūden",
        "2007",
        "Animation, Action & Adventure, Sci-Fi & Fantasy",
        "Masashi Kishimoto",
        "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki",
         "https://www.themoviedb.org/tv/31910-naruto-shipp-den",
            "https://image.tmdb.org/t/p/original/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg"))
        shows.add(MovieTvDetailEntity(12,
        "The Walking Dead",
        "2010",
        "Action & Adventure, Drama, Sci-Fi & Fantasy",
        "Frank Darabont",
        "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
          "https://www.themoviedb.org/tv/1402-the-walking-dead",
            "https://image.tmdb.org/t/p/original/qgjP2OrrX9gc6M270xdPnEmE9tC.jpg"))

        for (show in shows){
            if (show.id.toString() == tvShowId){
                showDetail.id = show.id
                showDetail.title = show.title
                showDetail.year = show.year
                showDetail.genre = show.genre
                showDetail.producer = show.producer
                showDetail.overview = show.overview
                showDetail.url = show.url
                showDetail.poster = show.poster
            }
        }

        return showDetail
    }

    /*fun getDetail(type: Int, id: Int): MovieTvDetailEntity {

        if (type == 1){
            dataAll = generateDummyDetailMovie()
        } else {
            dataAll = generateDummyDetailTVShow()
        }
        for (data in dataAll){
            if (data.id == id){
                detailData = data
            }
        }
        return detailData
    }*/

    fun generateNullTest(): ArrayList<MovieTvDetailEntity>{
        val itemNull = ArrayList<MovieTvDetailEntity>()
        itemNull.add(MovieTvDetailEntity(null,null,null,null,null,null,null, null))

        return itemNull
    }

    fun generateBlankTest(): ArrayList<MovieTvDetailEntity>{
        val itemBlank = ArrayList<MovieTvDetailEntity>()

        itemBlank.add(MovieTvDetailEntity(1,"","","","","","", null))

        return itemBlank
    }
}