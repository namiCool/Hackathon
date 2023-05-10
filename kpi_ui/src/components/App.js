import 'react-router-dom';
import ReactDOM from 'react-dom';
import React from 'react';
import NameForm from './NameForm';
import DropDown from './DropDown';
//const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render();



const App = () => {
  return (<>
  <div>
        <h2> 
           {" "}
           Using the <i> React inline styles </i> to set a background image
        </h2>
        <br></br>
        <div
           class = "image"
           style = {{
              height: "500px",
              width: "700px",
               backgroundImage:
              'url("https://cdn.shortpixel.ai/spai/ret_img/https://www.apptio.com/wp-content/uploads/Data-art-2-01.svg  ")',
              align:'center',
              backgroundSize: "contain",
              backgroundRepeat: "no-repeat",
           }}
        >
         <NameForm/>
<DropDown/>
        </div>
     </div>

    </>);
};



export default  App;