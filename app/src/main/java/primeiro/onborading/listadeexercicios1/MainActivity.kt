package primeiro.onborading.listadeexercicios1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import primeiro.onborading.listadeexercicios1.ui.theme.ListaDeExercicios1Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkoutScreen()
        }
    }
}

@Preview
@Composable
fun WorkoutScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFFFFFFF))
            .verticalScroll(rememberScrollState())
    ){
        HeaderSection()

        ExerciseList(
            exercises = listOf(
                Exercise("Supino Reto", 12, 4, 60),
                Exercise("Agachamento", 12, 3, 90),
                Exercise("Rosca Direta", 15, 4, 45),
                Exercise("Supino Inclinado", 10, 4, 60),
                Exercise("Leg Press", 15, 3, 90),
                Exercise("Puxada Frontal", 12, 4, 60),
                Exercise("Desenvolvimento de Ombros", 12, 3, 45),
                Exercise("Flexão de Braço", 20, 3, 30),
                Exercise("Prancha", 1, 3, 60),
                Exercise("Extensora", 15, 4, 60),
                Exercise("Elevação Lateral", 12, 4, 45),
                Exercise("Supino Declinado", 12, 4, 60)
            )
        )
    }
}

@Composable
fun HeaderSection(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp)
    ){
        Text(
            text = "exercicios",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Pago: ", fontSize = 16.sp)
            var isChecked by remember { mutableStateOf(false) }
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
        }
    }
}

@Composable
fun ExerciseList(exercises:List<Exercise>){
    Column(modifier = Modifier.fillMaxWidth()){
        exercises.forEach { exercise ->
            ExerciseItem(exercise = exercise)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise){
    var isChecked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F1F1), shape = MaterialTheme.shapes.small)
            .padding(16.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = exercise.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Repetições: ${exercise.repetitions}", color = Color(0xFF030303))
            Text(text = "Séries: ${exercise.series}", color = Color(0xFF0E0E0C))
            Text(text = "Itervalo: ${exercise.interval}s", color = Color(0xFF0A0809))
        }
    }
}

data class Exercise(
    val name: String,
    val repetitions: Int,
    val series: Int,
    val interval: Int,
)




