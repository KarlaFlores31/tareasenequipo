package com.example.tareasenequipo.tarea4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GameListScreen(
    viewModel: Tarea4ViewModel,
    onBack: () -> Unit,
) {
    val games = viewModel.games
    var menuExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                .padding(vertical = 4.dp, horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
            }
            Text(
                "Videojuegos",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleLarge,
            )
            Box {
                IconButton(onClick = { menuExpanded = true }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "Opciones de vista")
                }
                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false },
                ) {
                    DropdownMenuItem(
                        text = { Text("Vista vertical (LazyColumn)") },
                        onClick = {
                            viewModel.updateLayoutVertical(true)
                            menuExpanded = false
                        },
                    )
                    DropdownMenuItem(
                        text = { Text("Vista horizontal (LazyRow)") },
                        onClick = {
                            viewModel.updateLayoutVertical(false)
                            menuExpanded = false
                        },
                    )
                }
            }
        }

        if (viewModel.layoutVertical) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                item {
                    WalletSummary(viewModel)
                }
                items(games, key = { it.id }) { game ->
                    GameCard(
                        game = game,
                        added = viewModel.isAdded(game.id),
                        blockReason = viewModel.reasonCannotAdd(game),
                        onAdd = { viewModel.tryAddGame(game) },
                    )
                }
                item {
                    FinishSection(viewModel)
                }
            }
        } else {
            Column(modifier = Modifier.weight(1f)) {
                WalletSummary(
                    viewModel = viewModel,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                )
                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(games, key = { it.id }) { game ->
                        GameCard(
                            game = game,
                            added = viewModel.isAdded(game.id),
                            blockReason = viewModel.reasonCannotAdd(game),
                            onAdd = { viewModel.tryAddGame(game) },
                            modifier = Modifier.width(300.dp),
                        )
                    }
                    item {
                        FinishSection(
                            viewModel = viewModel,
                            modifier = Modifier.width(280.dp),
                        )
                    }
                }
            }
        }
    }

    if (viewModel.finishDialogVisible) {
        AlertDialog(
            onDismissRequest = viewModel::dismissFinishDialog,
            title = { Text("Compra finalizada") },
            text = {
                Text(
                    "Total gastado: ${formatMoney(viewModel.totalSpent)}",
                    style = MaterialTheme.typography.bodyLarge,
                )
            },
            confirmButton = {
                TextButton(onClick = viewModel::dismissFinishDialog) {
                    Text("Aceptar")
                }
            },
        )
    }
}

@Composable
private fun WalletSummary(viewModel: Tarea4ViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            "Hola, ${viewModel.userName}",
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            "Saldo disponible: ${formatMoney(viewModel.remainingBalance)}",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun FinishSection(viewModel: Tarea4ViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Button(
            onClick = viewModel::openFinishDialog,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Finalizar compra")
        }
    }
}

@Composable
private fun GameCard(
    game: VideoGame,
    added: Boolean,
    blockReason: String?,
    onAdd: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(game.imagenResId),
                contentDescription = game.nombre,
                modifier = Modifier
                    .width(88.dp)
                    .height(110.dp),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(game.nombre, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleSmall)
                Text("Precio: ${formatMoney(game.precio)}", style = MaterialTheme.typography.bodyMedium)
                Text("Consola: ${game.consola}", style = MaterialTheme.typography.bodySmall)
                Text(
                    "Clasificación: ${game.clasificacion.code}",
                    style = MaterialTheme.typography.bodySmall,
                )
                if (added) {
                    Text(
                        "Agregado",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                } else {
                    if (blockReason != null) {
                        Text(
                            blockReason,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp),
                        )
                    }
                    Button(
                        onClick = onAdd,
                        enabled = blockReason == null,
                        modifier = Modifier.padding(top = 8.dp),
                    ) {
                        Text("Agregar al carrito")
                    }
                }
            }
        }
    }
}

private fun formatMoney(value: Float): String = "%.2f".format(value)
