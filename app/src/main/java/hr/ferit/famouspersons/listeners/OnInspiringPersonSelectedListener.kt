package hr.ferit.famouspersons.listeners

import hr.ferit.famouspersons.model.InspiringPerson

interface OnInspiringPersonSelectedListener {
    fun onInspiringPersonSelected(inspiringPerson: InspiringPerson)
}