import mysql.connector
import xlsxwriter
import datetime

from decouple import config

from flask import Flask

app = Flask(__name__)






def criar_excel(lista_dados):
    data = datetime.date.today()
    data_formatada = format(data, "%d/%m/%Y")

    # Create a workbook and add a worksheet.
    workbook = xlsxwriter.Workbook('relatorio-clientes.xlsx')
    worksheet = workbook.add_worksheet()
  

    f1 = workbook.add_format({
        'bg_color': '#C468CD',
        'align': 'center',
        'valign': 'center',
        'border': 1
    })

    f2 = workbook.add_format({
        'color': '#35DAF0',
        'bg_color': '#510090',
        'align': 'center',
        'valign': 'center',
        'border': 1
    })

    f3 = workbook.add_format({
        'align': 'center',
        'valign': 'center',
        'border': 1
    })

    worksheet.set_column('A:A', 30)
    worksheet.set_column('B:B', 30)
    worksheet.set_column('C:C', 30)
    worksheet.set_column('D:D', 30)
    worksheet.set_column('E:E', 30)


   
    worksheet.write('A1', 'ID', f2)
    worksheet.write('B1', 'NOME', f2)
    worksheet.write('C1', 'E-MAIL', f2)
    worksheet.write('D1', 'CPF/CNPJ', f2)
    worksheet.write('E1', 'TIPO', f2)
    row = 0
    col = 0
    for dado in lista_dados:
        row = row + 1
        if row % 2 == 0:
            worksheet.write(row, col, dado[0], f1)
            worksheet.write(row, col + 1, dado[3], f1)
            worksheet.write(row, col + 2, dado[2], f1)
            worksheet.write(row, col +3, dado[1], f1)
            tipo = ''
            if dado[5] == 1:
                tipo = 'PESSOA_FISICA'
            else:
                tipo = 'PESSOA_JURIDICA'
            worksheet.write(row, col + 4, tipo, f1)
            
        else:
            worksheet.write(row, col, dado[0], f3)
            worksheet.write(row, col + 1, dado[3], f3)
            worksheet.write(row, col + 2, dado[2], f3)
            worksheet.write(row, col +3, dado[1], f3)
            tipo = ''
            if dado[5] == 1:
                tipo = 'PESSOA_FISICA'
            else:
                tipo = 'PESSOA_JURIDICA'
            worksheet.write(row, col + 4, tipo, f3)
        

    workbook.close()

def conexao_banco():
        
    db_connection = mysql.connector.connect(host=config('HOST'), user=config('USER'), passwd=config('PASSWORD'), database=config('DATABASE'))
    lista_dados = db_connection.cursor()
    sql = "SELECT * FROM cliente"
    lista_dados.execute(sql)
    criar_excel(lista_dados)
    
    lista_dados.close()
    db_connection.commit()
    db_connection.close()



@app.route("/admin/gravar-arquivo-xlsx")
def index():
    conexao_banco()
    return "Enviado"

if __name__ == "__main__":
    app.run(host="127.0.0.1", port=8090, debug=True)
