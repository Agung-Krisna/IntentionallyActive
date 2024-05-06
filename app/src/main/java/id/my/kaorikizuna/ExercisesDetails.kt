package id.my.kaorikizuna

data class ExercisesTypes(
    val title: String,
    val description: String
)

val pushUp = ExercisesTypes(
    title = "Push Up",
    description = "Start in a plank position with your hands shoulder-width apart, then lower your body until your chest almost touches the ground before pushing back up to the starting position"
)

val squat = ExercisesTypes(
    title = "Squat",
    description = "Stand with your feet shoulder-width apart, then lower your body by bending your knees until your thighs are parallel to the ground. Push back up to the starting position"
)

val plank = ExercisesTypes(
    title = "Plank",
    description = "Lie on your stomach with your forearms flat on the ground, elbows under your shoulders, and neck in a neutral position. Press your elbows directly into the ground and squeeze your core and glutes, holding for upwards of 10 seconds"
)

val mountainClimbers = ExercisesTypes(
    title = "Mountain Climbers",
    description = "Start in a plank position with your hands down, keeping your core tight. Bring one knee as close to your chest as you can, then bring your foot back to resting and alternate"
)

val jumpingJacks = ExercisesTypes(
    title = "Jumping Jacks",
    description = "Stand with your feet hip-width apart, then jump your feet out to the sides while raising your arms above your head. Quickly return to the starting position"
)

val alternatingHighKnees = ExercisesTypes(
    title = "Alternating High Knees",
    description = "Start by standing with your feet hip-width apart. Lift your left knee towards your chest, while simultaneously moving your left hand in a pumping motion. Quickly lower your left leg and left hand, then repeat the process with your right leg and right hand. Continue alternating your right and left legs for the desired duration"
)


val exercises = listOf(
    pushUp, squat, plank, mountainClimbers
)

val warmUps = listOf(
    jumpingJacks, alternatingHighKnees
)