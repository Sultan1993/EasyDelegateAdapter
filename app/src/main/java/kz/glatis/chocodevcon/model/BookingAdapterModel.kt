package kz.glatis.chocodevcon.model

import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem

data class BookingAdapterModel(
    val departureCity: String,
    val arrivalCity: String,
    val departureTime: String,
    val arrivalTime: String
): DelegateAdapterItem {

    override fun id(): Any = BookingAdapterModel::class.toString()

    override fun content(): Any = BookingContent(departureTime, arrivalTime)

    override fun payload(other: Any): DelegateAdapterItem.Payloadable {
        if (other is BookingContent) {
            if (departureTime != other.departureTime) {
                return ChangePayload.DepartureTimeChanged(other.departureTime)
            }

            if (arrivalTime != other.arrivalTime) {
                return ChangePayload.ArrivalTimeChanged(other.arrivalTime)
            }
        }
        return DelegateAdapterItem.Payloadable.None
    }

    inner class BookingContent(val departureTime: String, val arrivalTime: String) {
        override fun equals(other: Any?): Boolean {
            if (other is BookingContent) {
                return departureTime == other.departureTime && arrivalTime == other.arrivalTime
            }
            return false
        }

        override fun hashCode(): Int {
            var result = departureTime.hashCode()
            result = 31 * result + arrivalTime.hashCode()
            return result
        }
    }

    sealed class ChangePayload: DelegateAdapterItem.Payloadable {
        data class DepartureTimeChanged(val departureTime: String): ChangePayload()
        data class ArrivalTimeChanged(val arrivalTime: String): ChangePayload()
    }
}