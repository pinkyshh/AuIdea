package api

class Recommendation : ArrayList<RecommendationItem>()

data class RecommendationItem(
    val groupName: String,
    val projectTitle: String,
    val projectType: Int,
    val semester: String
)