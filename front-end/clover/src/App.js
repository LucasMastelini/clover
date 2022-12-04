import Router from "./routes/Router";
import VLibras from "@djpfs/react-vlibras";

function App() {
  return (
    <div>
      <VLibras forceOnload={true}/>
        <Router />
    </div>
  );
}

export default App;
