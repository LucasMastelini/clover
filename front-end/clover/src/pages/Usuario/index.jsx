import Header from "../Header";
import Pedidos from "./pages/Pedidos";
import SideBar from "./Sidebar/SideBar.jsx";
import "./style.css";

function Usuario() {
  return (
    <>
      <Header />
      <div className="container-geral">
      <SideBar/>
      <Pedidos />
      </div>
    </>
  );
}

export default Usuario;
