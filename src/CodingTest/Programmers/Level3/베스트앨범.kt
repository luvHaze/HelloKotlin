package CodingTest.Programmers.Level3

private class BestAlbumSolution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val musics = makeMusicList(genres, plays)

        return makeBestAlbum(musics)
    }

    private fun makeBestAlbum(musics: ArrayList<Music>): IntArray {
        val musicHash = makeMusicHash(musics)
        val ranks = getRanking(musicHash)
        val idList = arrayListOf<Int>()
        for (rank in ranks) {
            val genre = rank.first
            musicHash[genre]?.sortByDescending { it.play }

            for (idx in 0 until 2) {
                if (musicHash[genre]!!.size > idx) {
                    idList.add(musicHash[genre]!!.get(idx).id)
                } else {
                    break
                }
            }
        }

        return idList.toIntArray()
    }

    private fun getRanking(musicHash: HashMap<String, ArrayList<Music>>): List<Pair<String, Int>> {
        return musicHash.map { entry ->
            Pair(entry.key, entry.value.sumBy { it.play })
        }.sortedByDescending { it.second }
    }


    private fun makeMusicHash(musics: ArrayList<Music>): HashMap<String, ArrayList<Music>> {
        val musicHash = HashMap<String, ArrayList<Music>>()
        for (music in musics) {
            val list = musicHash.getOrDefault(music.genre, arrayListOf<Music>())
            list.add(music)
            musicHash[music.genre] = list
        }

        return musicHash
    }

    private fun makeMusicList(genres: Array<String>, plays: IntArray): ArrayList<Music> {
        val musics = arrayListOf<Music>()
        for (idx in 0 until genres.size) {
            musics.add(Music(idx, genres[idx], plays[idx]))
        }
        return musics
    }

    data class Music(
        val id: Int,
        val genre: String,
        val play: Int
    )
}