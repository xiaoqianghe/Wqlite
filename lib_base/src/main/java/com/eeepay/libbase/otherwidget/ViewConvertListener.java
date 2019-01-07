package com.eeepay.libbase.otherwidget;

import java.io.Serializable;

public interface ViewConvertListener extends Serializable {
    long serialVersionUID = System.currentTimeMillis();

    void convertView(ViewHolder holder, AbsDialog dialog);
}