# UI Handoff Notes (XML layouts)

Notes from the UI team for the logic team. The XML layouts are in `app/src/main/res/`.

## Screens

| Layout | Purpose |
|---|---|
| `layout/activity_patient_list.xml` | Phone: toolbar, navigation drawer and patient list |
| `layout-sw600dp/activity_patient_list.xml` | Tablet: patient list on the left, patient details on the right, on one screen |
| `layout/activity_patient_details.xml` | Phone: patient header and medical history |

`PatientListActivity` and `PatientDetailsActivity` contain only `setContentView(...)`. All logic is for the logic team.

## View IDs

| Screen | IDs |
|---|---|
| Phone list | `drawerLayout`, `toolbar`, `rvPatients`, `navView` |
| Patient row (`item_patient`) | `patientRow`, `tvPatientName`, `tvPatientSummary` |
| Drawer menu items | `nav_patient_list`, `nav_patient_details` |
| Details screen | `toolbar`, `tvDetailName`, `tvSex`, `tvAge`, `tvPatientId`, `rvHistory` |
| History item (phone card and tablet row) | `tvVisitDate`, `tvDiagnosis`, `tvTreatment`, `tvNotes` |
| Tablet layout | `toolbar`, `rvPatients`, `tvDetailName`, `tvSex`, `tvAge`, `tvPatientId`, `rvHistory` |

## Things to watch

1. **Tablet has no drawer.** The tablet layout has no `drawerLayout` or `navView`. Null-check them, or `findViewById` returns null and the app crashes on tablets.
2. **Two history layouts.** Inflate `item_history_card` on phones and `item_history_row` (the table row) on tablets.
3. **Selected patient on tablet.** Call `setActivated(true)` on the selected row. The highlight is already in the layout.
4. **Text formats from the design.**
   - Summary line: `Female · 34 yrs · UHC-00214`
   - Age on the details screen: `34 years`
5. **Sample text is preview-only.** Text in the XML uses `tools:text`, so nothing is hardcoded. Set the real data from Java.
6. **Reuse resources.** Colors, strings and styles are in `res/values`. Please reuse them and don't hardcode colors.

## Changing the UI

If you need a new view (a search box, a loading spinner, and so on), ask the UI developer to add it to the XML instead of editing the layouts yourself. This avoids merge conflicts.
