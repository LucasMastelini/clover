import React from "react";
import { useEffect } from "react";
import { useState } from "react";

import "./style.css";

function IconNav(props) {
  const [sub_categoria, setSubCategoria] = useState(props.sub_categoria);

  return (
    <div className="texto">
    {sub_categoria.map((item) => {
      return (
        <p>{item}</p>
      )
    })}
    </div>
  );
}

export default IconNav;
