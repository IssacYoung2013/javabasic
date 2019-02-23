package com.interview.javabasic.jvm.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class NormalObjectWeakReference extends WeakReference<NormalObject> {
    public String name;

    public NormalObjectWeakReference(NormalObject referent, ReferenceQueue<? super NormalObject> q) {
        super(referent, q);
        this.name = referent.name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing NormalObjectWeakReference " + name);
    }
}
