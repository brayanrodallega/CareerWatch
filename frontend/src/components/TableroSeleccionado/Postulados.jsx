import React from "react";
import { useParams } from "react-router-dom";
import { Tarjetas } from "./Tarjetas";

export const Postulados = () => {

   const {id} = useParams();
  

  return (
    <div className="bg-white text-black w-[98vw] h-[100vh] flex flex-col items-center gap-y-[1.5vh]">
      <div className="w-[90vw] text-[1.15em] text-star text-700 font-bold flex flex-row items-center mt-[5vh] mb-3">
        <img className="w-[10vw]  mr-3 " src="../trello.svg" alt="1"></img>
        <h2 className="font-['Lato','sans-serif'] font-bold">Postulaciones</h2>
      </div>
      <button className='w-[90vw] h-[6vh] flex items-center justify-center bg-[#6D28D9] text-white font-["Lato","sans-serif"] font-normal rounded-md drop-shadow-md'>
        +
      </button>
      <div>
        <Tarjetas/>
      </div>  
    </div>
  );
};