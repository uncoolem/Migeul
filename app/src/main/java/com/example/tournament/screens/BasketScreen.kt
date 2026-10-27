package com.example.tournament.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tournament.data.Tournament

@Composable
fun BasketScreen(tournament: Tournament, onBackClick: () -> Unit) {
    Scaffold(
        containerColor = Color(0xFFF0F5FA)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Join Tournament", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = "Pay the ${tournament.entryFee} tournament entry fee.", fontSize = 14.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = tournament.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text = tournament.format, fontSize = 12.sp, color = Color.Gray)
                        }
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Color(0xFFEBF3FF)
                        ) {
                            Text(
                                text = tournament.entryFee,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0066FF)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = Color(0xFFF1F1F1))
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Demo QR gateway", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text(text = "Static payment preview only", fontSize = 12.sp, color = Color.Gray)
                        }
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color(0xFFFFF3DB)
                        ) {
                            Text(
                                text = "Pending",
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB27700)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "Payment amount", fontSize = 12.sp, color = Color.Gray)
                    Text(text = "$5.00", fontSize = 28.sp, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFF7F7F7)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "[ DEMO QR CODE ]", fontWeight = FontWeight.Bold, color = Color.LightGray)
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "In a live gateway, scan with your wallet and confirm the $5.00 entry fee.",
                        fontSize = 11.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Awaiting payment · demo", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = onBackClick,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
            ) {
                Text("Back to tournaments", fontWeight = FontWeight.Bold)
            }
        }
    }
}