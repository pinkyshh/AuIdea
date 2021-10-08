package api

class Recommendation : ArrayList<RecommendationItem>()

data class RecommendationItem(
    val groupName: String,
    val projectNo: Int,
    val projectRank: Int,
    val projectTitle: String,
    val projectType: Int,
    val semester: String,
    val studentId: Int
)