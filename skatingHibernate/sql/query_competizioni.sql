SELECT 
    i.numero,i.asd, c.categoria, c.specialita, c.disciplina, c.classe, c.gruppo, c.id
FROM
    iscrizioni i
        INNER JOIN
    competizioni c ON i.categoria = c.categoria
        AND i.specialita = c.specialita
        AND i.disciplina = c.disciplina
        AND i.classe = c.classe
        AND i.gruppo = c.gruppo
order by c.id