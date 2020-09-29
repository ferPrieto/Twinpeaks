package prieto.fernando.twinpeaks.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionManager{

    private val REQUEST_CODE_ASK_PERMISSIONS = 1
    private val PERMISSIONS_ARRAYS = arrayOf(
        Manifest.permission.CAMERA
    )

    // List of permissions to be applied for.
    private val permissionsList: MutableList<String> = mutableListOf()

    fun onResume(activity: Activity?) {
        var isHasPermission = true
        for (permission in PERMISSIONS_ARRAYS) {
            if (ContextCompat.checkSelfPermission(
                    activity!!,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                isHasPermission = false
                break
            }
        }
        if (!isHasPermission) {
            for (permission in PERMISSIONS_ARRAYS) {
                if (ContextCompat.checkSelfPermission(
                        activity!!,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    permissionsList.add(permission)
                }
            }
            ActivityCompat.requestPermissions(
                activity!!,
                permissionsList.toTypedArray(),
                REQUEST_CODE_ASK_PERMISSIONS
            )
        }
    }

    fun hasPermission(activity: Activity): Boolean {
        for (permission in PERMISSIONS_ARRAYS) {
            if (ContextCompat.checkSelfPermission(
                    activity,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }
}