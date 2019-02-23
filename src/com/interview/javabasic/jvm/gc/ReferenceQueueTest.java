package com.interview.javabasic.jvm.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 *
 * author:  ywy
 * date:    2019-02-17
 * desc:
 */
public class ReferenceQueueTest {
    private static ReferenceQueue<NormalObject> rq = new ReferenceQueue<>();

    private static void checkQueue() {
        Reference<NormalObject> ref;
        ref = null;
        while ((ref = (Reference<NormalObject>)rq.poll()) != null) {
            if(ref != null) {
                System.out.println("In queue: " + ((NormalObjectWeakReference)(ref)).name);
                System.out.println("reference object: " +  ref.get());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<WeakReference<NormalObject>> weakReferences = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            weakReferences.add(new NormalObjectWeakReference(new NormalObject("weak" + i),rq));
            System.out.println("Created weak:" + weakReferences.get(i));
        }
        System.out.println("first time");
        checkQueue();
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second time");
        checkQueue();
    }
}
