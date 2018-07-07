package com.neocom.mobilerefueling.download;


import com.neocom.mobilerefueling.downloadeffects.BaseEffects;
import com.neocom.mobilerefueling.downloadeffects.FadeIn;
import com.neocom.mobilerefueling.downloadeffects.Fall;
import com.neocom.mobilerefueling.downloadeffects.FlipH;
import com.neocom.mobilerefueling.downloadeffects.FlipV;
import com.neocom.mobilerefueling.downloadeffects.NewsPaper;
import com.neocom.mobilerefueling.downloadeffects.RotateBottom;
import com.neocom.mobilerefueling.downloadeffects.RotateLeft;
import com.neocom.mobilerefueling.downloadeffects.Shake;
import com.neocom.mobilerefueling.downloadeffects.SideFall;
import com.neocom.mobilerefueling.downloadeffects.SlideBottom;
import com.neocom.mobilerefueling.downloadeffects.SlideLeft;
import com.neocom.mobilerefueling.downloadeffects.SlideRight;
import com.neocom.mobilerefueling.downloadeffects.SlideTop;
import com.neocom.mobilerefueling.downloadeffects.Slit;

/**
 * Created by smartTop on 2016/12/23.
 */

public enum Effectstype {
    Fadein(FadeIn.class),
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    Slidebottom(SlideBottom.class),
    Slideright(SlideRight.class),
    fall(Fall.class),
    Newspager(NewsPaper.class),
    Fliph(FlipH.class),
    Flipv(FlipV.class),
    Rotatebottom(RotateBottom.class),
    Rotateleft(RotateLeft.class),
    slit(Slit.class),
    shake(Shake.class),
    Sidefill(SideFall.class);
    private Class<? extends BaseEffects> effectsClazz;

    Effectstype(Class<? extends BaseEffects> mclass) {
        effectsClazz = mclass;
    }
    public BaseEffects getAnimator() {
        BaseEffects bEffects = null;
        try {
            bEffects = effectsClazz.newInstance();
        } catch (ClassCastException e){
            throw new Error("Can not init animatorClazz instance");
        }catch (InstantiationException e) {
            throw new Error("Can not init animatorClazz instance");
        } catch (IllegalAccessException e) {
            throw new Error("Can not init animatorClazz instance");
        }
        return bEffects;
    }
}
