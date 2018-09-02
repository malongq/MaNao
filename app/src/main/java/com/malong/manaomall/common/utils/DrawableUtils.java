package com.malong.manaomall.common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.mikepenz.iconics.IconicsDrawable;

/**
 * Created by Malong
 * on 18/6/14.
 * 辅助引用自定义SVG图工具类
 */
public class DrawableUtils {

    public static Drawable drawable(Context context, IconUtils.Icon icon, int color, int dpSize) {

        Drawable iconicsDrawable = new IconicsDrawable(context)
                .icon(icon)
                .color(color)
                .sizeDp(dpSize);
        return iconicsDrawable;

    }
}
