package com.zipe.util.copy

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

/**
 * @Description: 通過序列化/反序列化方式完成深複製
 */
object DeepCopyUtils {
    /**
     * 要求data對象及其引用對像都實現了Serializable接口才可以用
     * 針對Object、數組、Map、List類型
     *
     * @param source
     * @return
     * @throws Exception
     */
    fun <T> deepCopyObject(source: T?): T? {
        var dest: T? = null
        if (source == null) {
            return dest
        }
        try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(source)
            //从流里读出来
            val bais = ByteArrayInputStream(baos.toByteArray())
            val oi = ObjectInputStream(bais)
            dest = oi.readObject() as T
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return dest
    }

    /**
     * 要求data對象及其引用對像都實現了Serializable接口才可以用
     * 針對List類型
     *
     * @param src
     * @return
     */
    fun <T> deepCopyList(src: List<T>?): List<T>? {
        var dest: List<T>? = null
        if (src == null) {
            return dest
        }
        try {
            val byteOut = ByteArrayOutputStream()
            val out = ObjectOutputStream(byteOut)
            out.writeObject(src)
            val byteIn = ByteArrayInputStream(byteOut.toByteArray())
            var `in`: ObjectInputStream? = null
            `in` = ObjectInputStream(byteIn)
            dest = `in`.readObject() as List<T>
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return dest
    }

    /**
     * 要求data對象及其引用對像都實現了Serializable接口才可以用
     * 針對數組類型
     *
     * @param source
     * @return
     */
    fun <T> deepCopyArray(source: Array<T>?): Array<T>? {
        var dest: Array<T>? = null
        try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(source)
            //從流裡讀出來
            val bais = ByteArrayInputStream(baos.toByteArray())
            val oi = ObjectInputStream(bais)
            dest = oi.readObject() as Array<T>
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return dest
    }
}
