import React from "react";
import Step from "../step";

export default function StepNavigation(props) {
   
    return (
        <div className="stepWrapper">
            {props.labelArray.map((item, index) => <Step key={index} index={index} label={item} updateStep={props.updateStep} currentStep={props.currentStep} selected={props.currentStep === index + 1 || props.currentStep >= 5}></Step>) }
        </div>
        
    )
}

