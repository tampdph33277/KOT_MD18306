package com.example.lab7


data class Movie(
    var title: String, var year: String, var posterUrl: String, var time: Int, var
    date: String, var genre: String, var shortDesc: String
) {
    companion object {
        fun getSampleMovie() = listOf(
            Movie(
                "Hành Tinh Cát - Phần 2", "2024",
                "https://upload.wikimedia.org/wikipedia/vi/9/94/Dune_2_VN_poster.jpg",
                20, "14/03/2024", "Phim hành động",
                "\"Hành Tinh Cát Phần 2\" tiếp tục cuộc hành trình kỳ diệu của nhóm phi hành gia trên hành tinh sa mạc, khám phá bí ẩn và đối mặt với nguy hiểm mới."
            ),
            Movie(
                "Mai", "2023",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBwxAkLxonf5ByHa2ZNf3Aij7WTAxIlLeCq1rCyX5qHg&s",
                20, "29/12/2023", "Phim tình cảm",
                "\"Mai\" là câu chuyện về một cô bé Việt Nam trải qua những thách thức, khám phá văn hóa mới và tìm kiếm ước mơ."
            ),
            Movie(
                "Đào, Phở, Piano", "2024",
                "https://www.elle.vn/wp-content/uploads/2024/02/28/573479/poster-phim-dao-pho-va-piano.jpg",
                20, "21/01/2024", "Phim tài liệu",
                "\"Đào, Phở, Piano\" kể về hành trình của một cậu bé Việt trong việc khám phá và chinh phục ước mơ âm nhạc."
            ),


            )
    }
}