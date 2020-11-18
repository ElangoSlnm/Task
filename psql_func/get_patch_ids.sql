DROP FUNCTION IF EXISTS ego.get_patch_ids (p_sql text, p_part integer);

CREATE OR REPLACE FUNCTION ego.get_patch_ids (p_sql text, p_part integer DEFAULT 10000)
    RETURNS TABLE (
        ids integer[])
    LANGUAGE plpgsql
    AS $_$
DECLARE
    t_sql text;
BEGIN
    /* 
     1.0 elango_sellappan 18/Nov/2020 function to get patch of ids 
     SELECT * from ego.get_patch_ids (p_sql:='select generate_series(1, 100) as id', p_part:=20);
     */
    t_sql = '
        SELECT
            array_agg(id) AS ids
        FROM
            (' || p_sql || ') t
        GROUP BY id /' || p_part + 1 || '
        ORDER BY 1
    ';
    RETURN QUERY EXECUTE t_sql;
END
$_$;

ALTER FUNCTION ego.get_patch_ids (p_sql text, p_part integer) OWNER TO tester;