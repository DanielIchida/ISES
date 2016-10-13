<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <h3>Importar Datos</h3>
            <form action="http://localhost:9090/sica/coordinadores/insertMat" enctype="multipart/form-data" method="post">
                <input id="archivo" accept=".csv" name="archivo" type="file" /><br>
                <input name="MAX_FILE_SIZE" type="hidden" value="20000" /><br>
                <input name="enviar" type="submit" value="Importar" />
            </form>
        </div>
        <div class="col-sm-6">
            <h3>Registrar Materia</h3>
            <form action="http://localhost:9090/sica/coordinadores/insertForm" method="post">
                <input type="text" name="codigo" placeholder="Ingresar codigo" /><br>
                <input type="text" name="nombre" placeholder="Ingresar nombre" /><br>
                <label>Seleccionar dia</label>
                <select name="dia">
                    <option value="Lunes">Lunes</option>
                    <option value="Martes">Martes</option>
                    <option value="Miercoles">Miercoles</option>
                    <option value="Jueves">Jueves</option>
                    <option value="Viernes">Viernes
                    <option value="Sabado">Sabado</option>
                </select><br>
                <label>Seleccionar Horario</label>
                <select name="horario">
                    <option value="6:00pm - 8:00pm">6:00 pm - 8:00 pm</option>
                    <option value="8:00pm - 10:00pm">8:00 pm - 10:00 pm</option>
                    <option value="8:00am - 10:00am">8:00 am - 10:00 am</option>
                    <option value="10:00pm - 12:00pm">10:00 pm - 12:00 pm</option>
                </select><br>
                <input type="submit" value="Registrar" />
            </form>
        </div>
    </div>
</div>