import React from "react";

export default function Step(props) {

    setTimeout(() => {      
     props.updateStep(props.currentStep + 1)
     console.log(props.currentStep)
     console.log(props.index <= props.currentStep)
    }, 15000)
    return (
        <div className={"stepBlock" + (props.selected ? " selected" : "")}>
            <div className="circleWrapper">
                <div className={"circle " + (props.index <= props.currentStep ? "" : " selected")}>{props.index + 1}</div>
            </div>
            <span>{props.label}</span>
        </div>

         
    )
   // onClick={() => props.updateStep(props.index + 1)}
   
}