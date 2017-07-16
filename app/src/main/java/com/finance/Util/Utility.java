package com.finance.Util;

import android.support.v4.app.Fragment;

import com.finance.Data.PremiumData;
import com.finance.Fragments.ProductIllustrationFragments.EightFragments.ChildAdvantageEightFragment;
import com.finance.Fragments.ProductIllustrationFragments.EightFragments.FlexiSaveEightFragment;
import com.finance.Fragments.ProductIllustrationFragments.FourFragments.ChildAdvantageFourFragment;
import com.finance.Fragments.ProductIllustrationFragments.FourFragments.FlexiSaveFourFragment;

/**
 * Created by Avinash on 3/11/2016.
 */
public class Utility {
    public static void changeMode(int mode,Fragment fragment){
        if(fragment instanceof ChildAdvantageFourFragment){
            ((ChildAdvantageFourFragment)fragment).changeMode(mode);
        }else if(fragment instanceof ChildAdvantageEightFragment){
            ((ChildAdvantageEightFragment)fragment).changeMode(mode);
        }
    }

    public static void sendData(PremiumData data,Fragment fragment){
        if(fragment instanceof FlexiSaveFourFragment){
            ((FlexiSaveFourFragment)fragment).setData(data);
        }else if(fragment instanceof FlexiSaveEightFragment){
            ((FlexiSaveEightFragment)fragment).setData(data);
        }
    }
}
