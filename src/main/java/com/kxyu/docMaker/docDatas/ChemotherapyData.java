package com.kxyu.docMaker.docDatas;

import com.kxyu.docMaker.document.AbstractDocumentVo;

/**
 * @Author: kxyu
 * @Date: Created in 9:52 2018/1/19
 */
public class ChemotherapyData extends AbstractDocumentVo{
    public ChemotherapyData(String mDisease, String mDrug, String mGene, String mRS, String mEvidenceLevel, String mGenotype, String mAnnotation) {
        this.mDisease = mDisease;
        this.mDrug = mDrug;
        this.mGene = mGene;
        this.mRS = mRS;
        this.mEvidenceLevel = mEvidenceLevel;
        this.mGenotype = mGenotype;
        this.mAnnotation = mAnnotation;
    }

    public String mDisease;

    public String mDrug;

    public String mGene;

    public String mRS;

    public String mEvidenceLevel;

    public String mGenotype;

    public String mAnnotation;


    public String getmDisease() {
        return mDisease;
    }

    public String getmDrug() {
        return mDrug;
    }

    public void setmDrug(String mDrug) {
        this.mDrug = mDrug;
    }

    public String getmGene() {
        return mGene;
    }

    public void setmGene(String mGene) {
        this.mGene = mGene;
    }

    public String getmRS() {
        return mRS;
    }

    public void setmRS(String mRS) {
        this.mRS = mRS;
    }

    public String getmEvidenceLevel() {
        return mEvidenceLevel;
    }

    public void setmEvidenceLevel(String mEvidenceLevel) {
        this.mEvidenceLevel = mEvidenceLevel;
    }

    public String getmGenotype() {
        return mGenotype;
    }

    public void setmGenotype(String mGenotype) {
        this.mGenotype = mGenotype;
    }

    public String getmAnnotation() {
        return mAnnotation;
    }

    public void setmAnnotation(String mAnnotation) {
        this.mAnnotation = mAnnotation;
    }

    public void setmDisease(String mDisease) {
        this.mDisease = mDisease;
    }

    public String findPrimaryKey() {
        return this.mDisease;
    }
}
