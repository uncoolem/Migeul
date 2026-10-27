package com.example.tournament.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tournament.data.Tournament

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onJoinClick: (Tournament) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("All") }

    val sampleTournaments = listOf(
        Tournament("1", "Clash Royale Open", "1v1 • 128 players", "$5 entry", "Starts in 18 min", "👑"),
        Tournament("2", "Apex Legends Duos", "2v2 • 64 teams", "$10 entry", "Starts in 1 hr 12 min", "🎯"),
        Tournament("3", "Rocket League 3v3", "3v3 • 32 teams", "$3 entry", "Starts in 2 hr 45 min", "⚽")
    )

    Scaffold(
        topBar = {
            Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)) {
                Text(
                    text = "Tournaments",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Discover live brackets and join with an entry fee.",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        },
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search tournaments", color = Color.Gray) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF7F7F7),
                    unfocusedContainerColor = Color(0xFFF7F7F7),
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf("All", "Upcoming", "Free", "Paid").forEach { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color.Black,
                            selectedLabelColor = Color.White,
                            containerColor = Color(0xFFF1F1F1),
                            labelColor = Color.Black
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(sampleTournaments) { tournament ->
                    TournamentCard(tournament = tournament, onJoinClick = { onJoinClick(tournament) })
                }
            }
        }
    }
}

@Composable
fun TournamentCard(tournament: Tournament, onJoinClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFEFEFEF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = tournament.gameIcon, fontSize = 20.sp)
                }
                Column {
                    Text(text = tournament.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = tournament.format, fontSize = 12.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = tournament.startTime, fontSize = 12.sp, color = Color.DarkGray, fontWeight = FontWeight.Medium)
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(text = tournament.entryFee, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onJoinClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text("Join", fontSize = 12.sp, color = Color.White)
                }
            }
        }
    }
}