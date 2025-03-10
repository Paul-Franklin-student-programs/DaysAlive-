import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.format.DateTimeParseException

class Calculations {
    companion object {
        // Method to calculate days alive
        fun birthdayCalc(day: String?, month: String?, year: String?): Any {
            // Step 1: Check for missing input
            if (day.isNullOrBlank() || month.isNullOrBlank() || year.isNullOrBlank()) {
                return "Error: Do not leave fields blank"
            }

            try {
                // Step 2: Convert inputs to integers
                val dayInt = day.toInt()
                val monthInt = month.toInt()
                val yearInt = year.toInt()

                // Step 3: Validate ranges
                if (monthInt !in 1..12 || yearInt !in 1900..2025 || dayInt !in 1..31) {
                    return "Error: Please enter valid birthday information"
                }

                // Step 4: Check if the date actually exists
                return try {
                    val userBorn = LocalDate.of(yearInt, monthInt, dayInt)
                    val todayDate = LocalDate.now()

                    // Step 5: Calculate and return difference in days
                    ChronoUnit.DAYS.between(userBorn, todayDate)
                } catch (e: DateTimeParseException) {
                    "Error: The date you entered does not exist!"
                }
            } catch (e: NumberFormatException) {
                return "Error: Please enter valid birthday information"
            }
        }


        fun getLifeStageMessage(daysAlive: Long): String {
            return when (daysAlive) {
                in 0..3652 -> "You're exploring and learning. Have fun, and follow your heart!" // 0 - 9 years
                in 3653..7304 -> "You're learning responsibility and finding out who you are. Be bold and free!" // 10 - 19 years
                in 7305..10957 -> "Enjoy your new freedoms and make plans for the future!" // 20 - 29 years
                in 10958..14609 -> "Friends, family, romance, independence, and everything in between!" // 30 - 39 years
                in 14610..18262 -> "You inspire others with your success as you achieve your dreams!" // 40 - 49 years
                in 18263..21914 -> "Your wisdom drives your accomplishments, and your compassion fuels your relationships." // 50 - 59 years
                in 21915..25567 -> "Reflecting on a life well lived, with excitement for what's to come!" // 60 - 69 years
                in 25568..29219 -> "Never too late to try something new, while celebrating the special people you have loved for so long." // 70 - 79 years
                in 29220..32872 -> "You understand the secrets of life better than anyone, and your warmth and insight bring happiness to others." // 80 - 89 years
                in 32873..36524 -> "Celebrate your sphere of special friends and enjoy their wonderful company!" // 90 - 99 years
                else -> "Wow! You reached 100! You have had so many adventures, but why not have some more?" // 100+
            }
        }


        fun determineSign(dayOfMonth: Int, monthValue: Int): String {
            return when {
                (monthValue == 3 && dayOfMonth >= 21) || (monthValue == 4 && dayOfMonth <= 19) -> "Aries"
                (monthValue == 4 && dayOfMonth >= 20) || (monthValue == 5 && dayOfMonth <= 20) -> "Taurus"
                (monthValue == 5 && dayOfMonth >= 21) || (monthValue == 6 && dayOfMonth <= 20) -> "Gemini"
                (monthValue == 6 && dayOfMonth >= 21) || (monthValue == 7 && dayOfMonth <= 22) -> "Cancer"
                (monthValue == 7 && dayOfMonth >= 23) || (monthValue == 8 && dayOfMonth <= 22) -> "Leo"
                (monthValue == 8 && dayOfMonth >= 23) || (monthValue == 9 && dayOfMonth <= 22) -> "Virgo"
                (monthValue == 9 && dayOfMonth >= 23) || (monthValue == 10 && dayOfMonth <= 22) -> "Libra"
                (monthValue == 10 && dayOfMonth >= 23) || (monthValue == 11 && dayOfMonth <= 21) -> "Scorpio"
                (monthValue == 11 && dayOfMonth >= 22) || (monthValue == 12 && dayOfMonth <= 21) -> "Sagittarius"
                (monthValue == 12 && dayOfMonth >= 22) || (monthValue == 1 && dayOfMonth <= 19) -> "Capricorn"
                (monthValue == 1 && dayOfMonth >= 20) || (monthValue == 2 && dayOfMonth <= 18) -> "Aquarius"
                (monthValue == 2 && dayOfMonth >= 19) || (monthValue == 3 && dayOfMonth <= 20) -> "Pisces"
                else -> "Error: Unable to find sign"  // Error case (invalid date)
            }
        }


    }
}

