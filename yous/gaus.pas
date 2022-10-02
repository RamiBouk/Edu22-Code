program gauss;
type 
matrix= Array of Array of Real;
var
  A: matrix;
  t:real;
  i,n,j,d:Integer;
(*__________________________________________*)
  function det(M: matrix;n:Integer): real;

var
  (* local variable declaration *)
  i,j: integer;
  m1,m2,res:real;

begin
  Writeln('calculating det');
  res:=0;
  if n=2 then res:=M[0,0]*M[1,1]-M[0,1]*M[1,0]
else 
begin
  for j:=0 to n-1 do
  begin
    m1:=1;
    m2:=1;
    for i :=0 to n-1 do 
begin
  m1:=m1*M[i,(i+j)mod n ];
  m2:=m2*M[n-1-i,(i+j)mod n ];
end;
res:=res+m1-m2;
    end;

  end;
  Write('det = ');
  WriteLn(res);
det:= res;
end;
(*________________________________________________*)
procedure show(M: matrix;n:Integer);
var
  (* local variable declaration *)
  i,j: integer;

begin
  for i:=0 to n-1 do
  begin
    for j:=0 to 2*n-1 do 
    Write(M[i,j]);
    Write(' | ');
    WriteLn();
  end;

end;
begin
  (* setting the size of the matrix*)
  Write('donner taile de matrice: ');
  ReadLn(n);
  SetLength(A,n,n*2);
  (*initializing A*)
  for i:=0 to n-1 do 
  for j :=0 to n-1 do 
  begin  
  Write('A[');
  Write(i);
  Write(j);
  Write(']<=');
  ReadLn(A[i,j]);
end;
if det(A,n)=0 then
  begin
  writeln('matrix doesnt have an inverse '); 
  exit;
end; 
(*initializing B*)
for d:=0 to n-1 do
  A[d,n+d]:=1;
Writeln('extended matrix:');
show(A,n);
(*
for i:=0 to n-1 do 
begin  
Write('B['+i+']<=');
ReadLn(B[i]);
    end;*)
    (*calc*)
    for d:=0 to n-1 do
    begin  
  t:=A[d,d];
  (* diag is 1*)
  for j :=d to 2*n-1 do
    A[d,j]:=A[d,j]/t;
  (* botom traingul is null*)
  for i:=0 to n-1 do 
  if i<>d then
  begin 
t:=A[i,d];
for j :=0 to 2*n-1 do 
A[i,j]:=A[i,j]-t*A[d,j];
       end;
     end;
     (*solve the equation*)

     WriteLn('results: ');
     show(A,n);

   end.
