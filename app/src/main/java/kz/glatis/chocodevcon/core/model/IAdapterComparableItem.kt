package kz.glatis.chocodevcon.core.model

/**
 * interface to be used with [DiffUtilCompositeAdapter], [PagingCompositeAdapter] items
 */
interface IAdapterComparableItem {

    /**
     * [DiffUtilCallback] uses this method to distinguish between items
     *
     * @return item's unique id that won't be changed
     */
    fun id(): Any

    /**
     * [DiffUtilCallback] uses this method to know, that item has changed
     *
     * @return data that represents visual part of the item
     */
    fun content(): Any
}