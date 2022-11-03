import React from "react";

import { useParams } from "react-router-dom";

function ResumoPedidos() {
  const { produtos } = useParams();

  return (<>{produtos}</>)
};

export default ResumoPedidos;