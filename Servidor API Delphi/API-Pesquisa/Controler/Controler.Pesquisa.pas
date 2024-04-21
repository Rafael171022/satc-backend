unit Controler.Pesquisa;

interface

uses Horse,
  System.JSON,
  System.SysUtils,
  Base, ActiveX, ADOInt, System.Win.ComObj, System.StrUtils, Classes, IdURI;

procedure RegistrarRotas;
procedure ListaTodosProdutos(Req: THorseRequest; Res: THorseResponse; Next: TProc);
procedure ListaProdutos(Req: THorseRequest; Res: THorseResponse; Next: TProc);
procedure InserirProduto(Req: THorseRequest; Res: THorseResponse; Next: TProc);
procedure DeletarProduto(Req: THorseRequest; Res: THorseResponse; Next: TProc);
function ConverterDataParaFormatoAceitavel(data: string): string;

var
  Sucedida, MalSucedida: integer;

implementation

uses Servidor;

procedure RegistrarRotas;
begin
  THorse.Get('/listarprodutos/:cod_produto', ListaProdutos);
  THorse.Get('/listartodos', ListaTodosProdutos);
  THorse.Post('/inserirproduto', InserirProduto);
  THorse.Delete('/deleteproduto/:cod_produto', DeletarProduto);
end;

procedure ListaProdutos(Req: THorseRequest; Res: THorseResponse; Next: TProc);
var
  Dados: TDM;
  Body: TJSONObject;
  cod_string:String;
  cod_produto: String;
begin
  try
    CoInitialize(nil);
    Dados := TDM.Create(nil);
    Body := Req.Body<TJSONObject>;
    cod_produto := Req.Params.Items['cod_produto'];
    Res.Send(Dados.ListarProduto(cod_produto)).Status(200);
    Inc(Sucedida);
    form_servidor.lbl_ok.Caption := IntToStr(Sucedida);
  finally
    FreeAndNil(Dados);
  end;

end;

procedure ListaTodosProdutos(Req: THorseRequest; Res: THorseResponse; Next: TProc);
var
  Dados: TDM;
  Body: TJSONObject;
  cod_string:String;
  cod_produto: String;
begin
  try
    CoInitialize(nil);
    Dados := TDM.Create(nil);
    Body := Req.Body<TJSONObject>;
    Res.Send(Dados.ListarTodosProdutos).Status(200);
    Inc(Sucedida);
    form_servidor.lbl_ok.Caption := IntToStr(Sucedida);
  finally
      FreeAndNil(Dados);
  end;

end;


function ConverterDataParaFormatoAceitavel(data: string): string;
var
  partes: TArray<string>;
begin
  // Divide a string da data em partes usando o separador "/"
  partes := data.Split(['/']);

  // Rearranja as partes na ordem "YYYY-MM-DD"
  Result := partes[2] + '-' + partes[1] + '-' + partes[0];
end;


procedure DeletarProduto(Req: THorseRequest; Res: THorseResponse; Next: TProc);
var
  Dados: TDM;
  Body,JsonResponse: TJSONObject;
  cod_produto: String;
begin
  try
    CoInitialize(nil);
    Dados := TDM.Create(nil);

    Body := Req.Body<TJSONObject>;
    cod_produto := Req.Params.Items['cod_produto'];
    Dados.DeleteProd(cod_produto);
    JsonResponse := TJSONObject.Create;

    if Existe = cod_produto then
    begin
      Inc(Sucedida);
      form_servidor.lbl_ok.Caption := IntToStr(Sucedida);
      JsonResponse := TJSONObject.Create;
      JsonResponse.AddPair('message', 'Produto '+cod_produto+' deletado com sucesso!');
      Res.Send(JsonResponse).Status(200);
    end
    else
    begin
      Inc(MalSucedida);
      form_servidor.lbl_fail.Caption := IntToStr(MalSucedida);
      JsonResponse.AddPair('message', 'Produto '+cod_produto+' não exite na base de dados');
      Res.Send(JsonResponse).Status(400);
    end;
  finally
    FreeAndNil(Dados)
  end;

end;

procedure InserirProduto(Req: THorseRequest; Res: THorseResponse; Next: TProc);
var
  Dados: TDM;
  Body: TJSONObject;
  cod_produto, desc_produto,dt_cad,dt_alt,cod_ean13: String;
  preco: Double;
  JsonResponse: TJSONObject;
begin
  try
    CoInitialize(nil);
    Body := Req.Body<TJSONObject>;
    Dados := TDM.Create(nil);

    cod_produto     := Body.GetValue<string>('cod_produto', '0');
    desc_produto    := Body.GetValue<string>('desc_produto', 'Sem descricao');
    cod_ean13       := Body.GetValue<string>('cod_ean13', '0');
    preco           := Body.GetValue<Double>('preco', 0);
    dt_cad          := Body.GetValue<string>('dt_cad','01-01-1900') ;
    dt_alt          := Body.GetValue<string>('dt_alt', '01-01-1900');


    Dados.InserirpProduto(cod_produto, desc_produto, cod_ean13, preco,dt_cad ,dt_alt);

    if Existe = '' then
    begin
      Inc(Sucedida);
      form_servidor.lbl_ok.Caption := IntToStr(Sucedida);
      JsonResponse := TJSONObject.Create;
      JsonResponse.AddPair('message', 'Itens gravados com sucesso!');
      JsonResponse.AddPair('cod_produto', cod_produto);
      Res.Send(JsonResponse).Status(201);
    end
    else
    begin
      Inc(MalSucedida);
      form_servidor.lbl_fail.Caption := IntToStr(MalSucedida);
      Res.Send('Produto já foi incluido!').Status(400);
    end;
  finally
    FreeAndNil(Dados)
  end;

end;

end.
