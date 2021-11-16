package com.example.filmography.models

object FilmsData {
    fun getFilms() = listOf(
        FilmModel(0, "Toy Story", "Was voted number 1 on the \"Top 100 Animated Features of All Time\" list by the Online Film Critics Society (published March 2003).", "1995", 8.9),
        FilmModel(1, "Casablanca", "Was voted the best romance film of all time with 56 votes in a 1996 poll of 100 experts organized by Spanish film magazine Nickel Odeon.", "1942", 8.5),
        FilmModel(2, "Some Like It Hot", "Was voted the best comedy film of all time in a poll of 253 film critics from 52 countries conducted by the BBC in 2017.", "1959", 9.1),
        FilmModel(3, "The Poseidon Adventure", "Was voted best disaster movie in a poll of 500 members of the UCI Cinemas staff in May 2004", "1972", 7.8),
        FilmModel(4, "The Exorcist", "Was voted the best horror film of all time with 53 votes in a 2012 poll of 150 experts conducted by Time Out London.", "1973", 7.6),
        FilmModel(5, "2001: A Space Odyssey ", "Was voted the best science fiction film of all time with 73 votes in a 2014 poll of 136 science fiction experts, filmmakers, science fiction writers, film critics, and scientists conducted by Time Out London", "1968", 8.4),
        FilmModel(6, "Titanic", "Was voted the most romantic film of all time in a poll conducted by Fandango in February 2011", "1997", 8.8),
        FilmModel(7, "Back to the Future", "Was the most cited film in a 2012 poll, when IndieWire asked 53 critics \"What is the best time travel movie ever made?\"", "1985", 7.5)
    )
}