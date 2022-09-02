import React, {Component} from "react";

import Dropzone from "react-dropzone";

import {DropContainer, UploadMassage} from './style';


export default class Upload extends Component {
    renderDragMessage = (isDragActive, isDragReject) => {
        if(!isDragActive){
            return <UploadMassage>Arraste arquivos aqui...</UploadMassage>
        }

        if(isDragReject){
            return <UploadMassage type="error" >Arquivo não suportado</UploadMassage>
        }

        return <UploadMassage type="success">Solte os arquivos aqui</UploadMassage>
    }

    render(){
        const {onUpload} = this.props;


        return (
            <Dropzone accept = "image/*" onDropAccepted={onUpload}>
               { ( {getRootProps, getInputProps, isDragActive, isDragReject}) => (
                   <DropContainer
                   {... getRootProps()}
                   isDragActive={isDragActive}
                   isDragReject={isDragReject}
                   >
                    <input {... getInputProps()}/>
                    {this.renderDragMessage(isDragActive, isDragReject)}
                   </DropContainer>
               ) }
            </Dropzone>// upload de qualquer arquivo de imagem
        );
    }
}

