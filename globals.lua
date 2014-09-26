-- live demo from lua.org
-- iterate all global variables
local seen = {}

function dump(t, i)
	seen[t] = true 
	-- create a new table to receive values from _G which contains all global variables
	-- table value marked by true means that when a table is dumped, it will not dump again.
	local s = {}
	local n = 0
	for k in pairs(t) do
		n = n + 1
		s[n] = k
	end
	-- iterate table _G in first layer, _G uses table as index and this table index represent a library name
	table.sort(s)
	-- sort table 
	for k,v in ipairs(s) do
		print(i, v)
		-- print library name
		v = t[v]
		-- v indicate a library name, so t[v] indicate method table belong to this library
		-- assignment method table to v
		if type(v) == 'table' and not seen[v] then
		-- iterate method table and judge whether the library has ever been dumped
			dump(v, i .. "\t")
		end
	end
end

dump(_G, "")
		