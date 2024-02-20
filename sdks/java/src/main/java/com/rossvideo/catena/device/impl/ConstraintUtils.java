package com.rossvideo.catena.device.impl;

import catena.core.constraint.Constraint;
import catena.core.constraint.Int32ChoiceConstraint;
import catena.core.constraint.Constraint.ConstraintType;
import catena.core.constraint.Int32ChoiceConstraint.IntChoice;

public class ConstraintUtils
{
    public static Constraint buildIntChoiceConstraint(String[] choices) {
        return buildIntChoiceConstraint(TextUtils.defaultLanguage, choices);
    }
    
    public static Constraint buildIntChoiceConstraint(String lang, String[] choices)
    {
        if (choices != null)
        {
            Constraint.Builder constraint = Constraint.newBuilder();
            Int32ChoiceConstraint.Builder intChoice = Int32ChoiceConstraint.newBuilder();
            for (int i = 0; i < choices.length; i++)
            {
                intChoice.addChoices(IntChoice.newBuilder()
                        .setValue(i)
                        .setName(TextUtils.createSimpleText(lang, choices[i])));
            }
            constraint.setType(ConstraintType.INT_CHOICE);
            constraint.setInt32Choice(intChoice);
            return constraint.build();
        }
        return null;
        
    }
}
