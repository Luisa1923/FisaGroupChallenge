  # language: es
  @FeatureName:musiccaInteractions
  Característica: Interacciones del usuario en plataforma Musicca


    Esquema del escenario:  Ejecucion en piano de la <Secuencia>
      Dado que el usuario ha navegado a la pagina musicca
      Cuando realiza interpretacion de la secuencia <Secuencia>
      Entonces las notas se ejecutan correctamente en el piano

      Ejemplos:
        |Secuencia    |
        |"secuencia1" |
        |"secuencia2" |
        |"secuencia3" |