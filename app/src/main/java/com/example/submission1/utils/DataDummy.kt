package com.example.submission1.utils

import com.example.submission1.data.MovieEntity
import com.example.submission1.data.TvShowEntity
import com.example.submission1.data.source.remote.response.DetailMovieResponse
import com.example.submission1.data.source.remote.response.DetailTvResponse
import com.example.submission1.data.source.remote.response.ResultsItem
import com.example.submission1.data.source.remote.response.ResultsItemTv

object DataDummy {
    fun getResultsItemMovie() : List<ResultsItem>{
        val movies = ArrayList<ResultsItem>()

        movies.add(ResultsItem("Original Title", "title", "posterPath", 1)
        )

        return movies
    }
    fun getResultsItemTv() : List<ResultsItemTv>{
        val movies = ArrayList<ResultsItemTv>()

        movies.add(ResultsItemTv("Name","poster Path", 1))

        return movies
    }
    fun getDetailMovie() : DetailMovieResponse{
        return DetailMovieResponse("EN",null, null, "title", "backdropPath",300000, null, null, null, 1,30, null
        ,"overview", "Original Title", null, "posterPath", null, null, "ReleaseDate",30.0,"tagline", true, "https://",
        "release")
    }
    fun getDetailTv() : DetailTvResponse{
        return DetailTvResponse("EN",null, null, "title", "backdropPath",null, null, 1, null, 1,"First Air Date", "Overview"
            ,null, null, null, null, null, null, null,"TV SHOW", 30.0, "Tv Show", "Tagline",
            null)
    }
    fun getDataMovie() : List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(1, "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
        "21 Jan 2020", 69.0)
        )
        movies.add(MovieEntity(2, "Tom Clancy's Without Remorse ",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.\n" +
                        "\n",
            "29/04/2021", 73.0)
        )
        movies.add(MovieEntity(3, "Alita: Battle Angel ",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "14/02/2019", 69.0)
        )
        movies.add(MovieEntity(4, "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "05/10/2018", 75.0)
        )
        movies.add(MovieEntity(4, "Spider-Man ",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man.",
            "22/05/2002", 72.0)
        )
        movies.add(MovieEntity(6, "Firefly",
                "In the year 2517, after the arrival of humans in a new star system, follow the adventures of the renegade crew of Serenity, a \"Firefly-class\" spaceship. The ensemble cast portrays the nine characters who live on Serenity.",
            "2002/08/21", 83.0)
        )
        movies.add(MovieEntity(7, "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.\n" +
                        "\n",
            "21/11/2018", 59.0)
        )
        movies.add(MovieEntity(8, "Wreck-It Ralph",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
            "01/12/2012", 73.0)
        )
        movies.add(MovieEntity(9, "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            "09/11/2018", 67.0)
        )
        movies.add(MovieEntity(10, "Mortal Engines ",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
            "14/12/2018 ", 61.0)
        )

        return movies
    }

    fun getDataTvShow() : List<TvShowEntity>{
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(TvShowEntity(1, "Dragon Ball Absalon",
"The series begins twelve years after Goku is seen leaving on Shenron not at the end of Dragon Ball GT, and diverges entirely into its own plot from there, on an alternate timeline from the one which shows Goku Jr. fighting Vegeta Jr. at the World Martial Arts Tournament. In this series, Majuub has reached new levels of power, and has honed the techniques taught to him by Goku. We also see Gotenks finally mature, and Vegeta more powerful than ever.Each character will bring forth their own set of capabilities and purpose, winning fights and being relevant, in order to create an environment that emphasizes teamwork as well as individual worth for each character. In this series, the main set of villains are Saiyans, with abilities highly similar to the Saiyans that we are familiar with. These new Saiyans are more powerful than any threat the Z Fighters have ever faced, but after twelve years of intensive training, our heroes will not be easily defeated .",
            "2012", 53.0)
        )
        tvShow.add(TvShowEntity(2, "Fairy Tail OVA 1 - Welcome to Fairy Hills!!",
                "We don't have an overview translated in English. Help us expand our database by adding one.\n" +
                        "\n" +
                        "We don't have any crew added to this movie. You can help by adding some!",
            "2011", 0.0)
        )
        tvShow.add(TvShowEntity(3, "Family Guy ",
    "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
         "1999", 70.0)
        )
        tvShow.add(TvShowEntity(4, "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "2014", 77.0)
        )
        tvShow.add(TvShowEntity(5, "God Friended Me",
                "A self-proclaimed \"pesky atheist\" is encouraged to help strangers by someone claiming to be God who friends him on Facebook",
            "2018", 81.0)
        )
        tvShow.add(TvShowEntity(6, "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "2014", 75.0)
        )
        tvShow.add(TvShowEntity(7, "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.\n" +
                        "\n",
            "2005", 82.0)
        )
        tvShow.add(TvShowEntity(8, "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "2019", 75.0)
        )
        tvShow.add(TvShowEntity(9, "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "2019", 76.0)
        )
        tvShow.add(TvShowEntity(10, "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow",
            "2012", 66.0)
        )

        return tvShow
    }
}