package ru.myapp.composeeducation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.myapp.composeeducation.enum.AvailableLocale
import ru.myapp.composeeducation.enum.EnumWrapper
import ru.myapp.composeeducation.enum.Font
import ru.myapp.composeeducation.enum.ReportType
import ru.myapp.composeeducation.enum.TransactionType
import ru.myapp.composeeducation.ui.theme.ComposeEducationTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    private val reports = EnumWrapper(ReportType.values().asList())
    private val fonts = EnumWrapper(Font.values().asList())
    private val locales = EnumWrapper(AvailableLocale.values().asList())
    private val slipTransactionTypes = EnumWrapper(arrayOf(
        TransactionType.INCOMING,
        TransactionType.REVERSAL,
        TransactionType.INCOMING_REFUND
    ).asList() )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeEducationTheme(darkTheme = false) {
                MainUI(
                    modifier = Modifier.fillMaxSize(),
                    reports = reports,
                    fonts = fonts,
                    locales = locales,
                    slipTransactionTypes = slipTransactionTypes,
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Suppress("LongMethod", "ComplexMethod")
fun MainUI(
    modifier: Modifier = Modifier,
    reports: EnumWrapper<List<ReportType>>,
    fonts: EnumWrapper<List<Font>>,
    locales: EnumWrapper<List<AvailableLocale>>,
    slipTransactionTypes: EnumWrapper<List<TransactionType>>,
) {

    var enabledActions by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    var reportExpanded by remember { mutableStateOf(false) }
    var reportSelection by remember { mutableStateOf(reports.list.first().toString()) }

    var fontExpanded by remember { mutableStateOf(false) }
    var fontSelection by remember { mutableStateOf(fonts.list.first().toString()) }

    var localeExpanded by remember { mutableStateOf(false) }
    var localeSelection by remember { mutableStateOf(locales.list.first().toString()) }

    var transactionTypeExpanded by remember { mutableStateOf(false) }
    var transactionTypeSelection by remember { mutableStateOf(slipTransactionTypes.list.first().toString()) }
    var transactionTypeVisibility by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrintingDropDownMenu(
            expanded = reportExpanded,
            onDropMenuToggle = { isExpanded ->
                if (enabledActions)
                    reportExpanded = isExpanded
            },
            onItemClick = {
                reportSelection = it.name
                transactionTypeVisibility = it == ReportType.SLIP_REPORT
            },
            selectedReportName = reportSelection,
            items = reports.list,
            label = "Select report type",
        )
        PrintingDropDownMenu(
            expanded = fontExpanded,
            onDropMenuToggle = { isExpanded ->
                if (enabledActions)
                    fontExpanded = isExpanded
            },
            onItemClick = {
                fontSelection = it.name
            },
            selectedReportName = fontSelection,
            items = fonts.list,
            label = "Select font type",
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrintingDropDownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                expanded = localeExpanded,
                onDropMenuToggle = { isExpanded ->
                    if (enabledActions)
                        localeExpanded = isExpanded
                },
                onItemClick = {
                    localeSelection = it.name
                },
                selectedReportName = localeSelection,
                items = locales.list,
                label = "Select locale",
            )
            if (transactionTypeVisibility) {
                PrintingDropDownMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    expanded = transactionTypeExpanded,
                    onDropMenuToggle = { isExpanded ->
                        if (enabledActions)
                            transactionTypeExpanded = isExpanded
                    },
                    onItemClick = {
                        transactionTypeSelection = it.name
                    },
                    selectedReportName = transactionTypeSelection,
                    items = slipTransactionTypes.list,
                    label = "Select transaction type",
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { enabledActions = false },
                enabled = enabledActions,
            ) {
                Text(text = "Printing")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = { enabledActions = true },
                enabled = !enabledActions,
            ) {
                Text(text = "Stop printing")
            }
        }
        if (enabledActions) {
            Text(text = message)
        } else {
            CircularProgressIndicator()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun <T> PrintingDropDownMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onDropMenuToggle: (isExpanded: Boolean) -> Unit = {},
    onItemClick: (T) -> Unit,
    selectedReportName: String,
    items: List<T>,
    label: String,
) {
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            onDropMenuToggle(!expanded)
        }
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            value = selectedReportName,
            onValueChange = { },
            label = { Text(text = label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onDropMenuToggle(false) }
        ) {
            items.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        onItemClick(selectionOption)
                        onDropMenuToggle(false)
                    }
                ) {
                    Text(text = selectionOption.toString())
                }
            }
        }
    }
}


